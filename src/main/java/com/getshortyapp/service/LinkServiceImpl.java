package com.getshortyapp.service;

import com.getshortyapp.entity.Link;

public interface LinkServiceImpl {
    Link saveLink(Link link);

    Link find(String url);
}
