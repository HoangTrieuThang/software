package com.example.software.services.impl;

import com.example.software.model.NewsKind;
import com.example.software.repository.NewsKindRepository;
import com.example.software.services.NewsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewKindServiceImpl implements NewsKindService {
    @Autowired
    private NewsKindRepository newsKindRepository;

    @Override
    public Page<NewsKind> listNewsKind(PageRequest pageRequest, String newsKindName) {
        return newsKindRepository.list(newsKindName, pageRequest);
    }

    @Override
    public NewsKind findNewsByNewKindId(Integer newKindId) {
        return newsKindRepository.findAllByNewsKindId(newKindId);
    }

    @Override
    public NewsKind create(NewsKind newsKind) {
        return newsKindRepository.save(newsKind);
    }

    @Override
    public NewsKind update(Integer id, NewsKind newsKind) throws Exception {
        Optional<NewsKind> optional = newsKindRepository.findById(id);
        if (optional.isEmpty()) {
            throw new Exception("abc");
        }
        return newsKindRepository.save(newsKind);
    }

    @Override
    public void delete(Integer id) {
        newsKindRepository.deleteByNewsKindId(id);
    }
}
