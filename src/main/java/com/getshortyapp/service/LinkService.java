package com.getshortyapp.service;

import com.getshortyapp.model.Link;
import com.getshortyapp.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    private LinksRepository linksRepository;

    // Save operation
    public Link saveLink(Link link) {
        return linksRepository.save(link);
    }
}
