package com.javainuse.springbootmgb;

import com.shortenlinkapp.ShortenLinkApplication;
import com.shortenlinkapp.entity.Link;
import com.shortenlinkapp.repository.LinkRepository;
import com.shortenlinkapp.service.LinkShortenerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.skyscreamer.jsonassert.JSONAssert.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ShortenLinkApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
class LinkShortenerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LinkRepository linkRepositoryMock;

	@SpyBean
	private LinkShortenerService linkShortenerService;

	public static List<Link> mockLinks = new ArrayList<>();

	@BeforeAll
	public static void setup() {
		Link mockLink1 = new Link();
		mockLink1.setShortened("123abc");
		mockLink1.setCurated("http://abc.com");
		Link mockLink2 = new Link();
		mockLink2.setShortened("456abc");
		mockLink2.setCurated("http://abc456.com");

		mockLinks.add(mockLink1);
		mockLinks.add(mockLink2);
	}

	@Test
	public void getAllLinks() throws Exception {
		Mockito.when(linkRepositoryMock.findAll()).thenReturn(mockLinks);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/short-links"))
				.andExpect(status().isOk())
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String contentResult = mvcResult.getResponse().getContentAsString();
		JSONObject linkDataObject = new JSONArray(contentResult).getJSONObject(0);
		assertEquals(linkDataObject.get("shortened"), mockLinks.get(0).getShortened());

		Mockito.verify(linkRepositoryMock, atLeast(1)).findAll();
	}

	@Test
	public void getUniqueStringNegative() throws Exception {
		Mockito.when(linkRepositoryMock.findByShortened(any())).thenReturn(mockLinks.get(0));
		doReturn("122345abc").when(linkShortenerService).getUniqueString();

		mockMvc.perform(MockMvcRequestBuilders.get("/short-link?rawUrl=http://www.abc.com"))
				.andExpect(status().is5xxServerError())
				.andReturn();
	}
}
