package com.example.software.services;

import com.example.software.model.NewsKind;

public interface AdminAccountService {
    NewsKind findNewsByNewKindId (Integer newKindId);

    NewsKind create(NewsKind newsKind);

    NewsKind update(Integer id, NewsKind newsKind) throws Exception;

    void delete(Integer id);
}
