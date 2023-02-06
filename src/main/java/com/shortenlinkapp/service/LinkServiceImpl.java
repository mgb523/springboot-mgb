package com.shortenlinkapp.service;

import com.shortenlinkapp.entity.Link;

public interface LinkServiceImpl {
    Link saveLink(Link link);

    Link find(String url);
}
