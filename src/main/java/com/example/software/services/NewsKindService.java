package com.example.software.services;

import com.example.software.model.NewsKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface NewsKindService {
    Page<NewsKind> listNewsKind(PageRequest pageRequest, String newsKindName);

    NewsKind findNewsByNewKindId (Integer newKindId);

    NewsKind create(NewsKind newsKind);

    NewsKind update(Integer id, NewsKind newsKind) throws Exception;

    void delete(Integer id);
}
