package com.getshortyapp.controller;

import com.getshortyapp.entity.Link;
import com.getshortyapp.repository.LinkRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class LinkShortenerController {

    @Autowired
    LinkRepository linkRepository;

    /**
     * Curate and shorten link with encoded uri
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/short-link")
    public URL getShortLink(@RequestParam(required = true, name="rawUrl") String rawUrl) throws Exception {
        String shortPath = Integer.toHexString(ThreadLocalRandom.current().nextInt(10000000, 999999999));
        String shortLink = "http://localhost:8989/" + shortPath;

        Link link = new Link();
        link.setCurated(rawUrl);
        link.setShortened(shortPath);
        link.setCount(0);
        linkRepository.save(link);

        return new URI(shortLink).normalize().toURL();
    }

    /**
     * Retrieve curated link for navigation and increase the link's navigation count
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping("/{path:[^\\\\.]*}")
    public RedirectView redirect(HttpServletRequest request) throws Exception {
        String path = new URI(request.getRequestURL().toString()).
                normalize().toURL().getPath().replace("/", "");
        Link link = linkRepository.findByShortened(path);
        link.setCount(link.getCount() + 1);
        linkRepository.save(link);

        String redirectToUrl = new URI(
                link.getCurated()).normalize().toURL().toString();

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectToUrl);
        return redirectView;
    }

    /**
     * Retrieve link's navigation count
     *
     * @param url
     * @return
     */
    @GetMapping("/usage-count")
    public Integer getUsageCount(@RequestParam(required = true, name="url") String url) {
        return 0;
    }
}