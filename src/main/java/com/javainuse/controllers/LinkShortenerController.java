package com.javainuse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URL;

@RestController
public class LinkShortenerController {

    /**
     * Curate and shorten link with encoded uri
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/short-link")
    public URL getShortLink(@RequestParam(required = true, name="rawUrl") String rawUrl) throws Exception {
        return new URI(rawUrl).normalize().toURL();
    }

    /**
     * Retrieve curated link for navigation and increase the link's navigation count
     *
     * @param url
     * @return
     * @throws Exception
     */
    @GetMapping("/curated-link")
    public URL getCuratedLink(@RequestParam(required = true, name="url") String url) throws Exception {
        return new URI(url).normalize().toURL();
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