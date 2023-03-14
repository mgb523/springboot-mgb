package com.shortenlinkapp.service;

import com.shortenlinkapp.entity.Link;
import com.shortenlinkapp.exception.DuplicateValueException;
import com.shortenlinkapp.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class LinkShortenerService {

    @Autowired
    LinkRepository linkRepository;

    @Value("${backend.hostname}")
    String hostname;

    public String shortenLink(String rawUrl) throws DuplicateValueException {
        String shortPath = getUniqueString();

        if (null != linkRepository.findByShortened(shortPath)) {
            throw new DuplicateValueException("The unique string created for this path already exists");
        }

        String shortLink = hostname.replace("\"", "") + "/" + shortPath;

        Link link = new Link();
        link.setCurated(rawUrl);
        link.setShortened(shortPath);
        link.setCount(0);
        linkRepository.save(link);

        return shortLink;
    }

    public String getUniqueString() {
        boolean isDuplicate = true;
        String shortPath = null;

        while (isDuplicate) {
            shortPath = Integer.toHexString(ThreadLocalRandom.current().nextInt(10000000, 999999999));
            isDuplicate = (null != linkRepository.findByShortened(shortPath));
        }

        return shortPath;
    }

    public String retrieveLink(String path) throws URISyntaxException, MalformedURLException {
        Link link = linkRepository.findByShortened(path);
        link.setCount(link.getCount() + 1);
        linkRepository.save(link);

        return new URI(link.getCurated()).normalize().toURL().toString();
    }
}
