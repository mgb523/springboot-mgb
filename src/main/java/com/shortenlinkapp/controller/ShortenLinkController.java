package com.shortenlinkapp.controller;

import com.shortenlinkapp.entity.Link;
import com.shortenlinkapp.repository.LinkRepository;
import com.shortenlinkapp.service.LinkShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@CrossOrigin(origins = "http://link-shortener-app.s3-website-us-east-1.amazonaws.com")
public class ShortenLinkController {

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    LinkShortenerService linkShortenerService;

    /**
     * Curate and shorten link with encoded uri
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/short-link")
    public String getShortLink(@RequestParam(required = true, name="rawUrl") String rawUrl) throws Exception {
        return linkShortenerService.shortenLink(rawUrl);
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

        String redirectToUrl = linkShortenerService.retrieveLink(path);

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