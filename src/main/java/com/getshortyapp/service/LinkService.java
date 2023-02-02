package com.getshortyapp.service;

import com.getshortyapp.entity.Link;
import com.getshortyapp.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements LinkServiceImpl {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link saveLink(Link link) {
        return linkRepository.save(link);
    }
}
