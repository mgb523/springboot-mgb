import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

public class LinkShortenerTest extends EndpointResource {

    @Test
    public void testShortenLink() throws IOException {
        // Given
        //String name = RandomStringUtils.randomAlphabetic( 8 );
        String rawUrl = "?rawUrl=http://nxp.com";
        HttpUriRequest request = new HttpGet(
                NAVIGATION_ROUTE +
                        SHORT_LINK +
                        rawUrl
        );

        // When
        StatusLine statusLine = HttpClientBuilder.create().build().execute(request).getStatusLine();

        // Then
        Assert.assertTrue(statusLine.getStatusCode() == HttpStatus.SC_OK);
    }
}
