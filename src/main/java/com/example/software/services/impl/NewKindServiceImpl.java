package com.example.software.services.impl;

import com.example.software.model.NewsKind;
import com.example.software.repository.NewsKindRepository;
import com.example.software.services.NewsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewKindServiceImpl implements NewsKindService {
    @Autowired
    private NewsKindRepository newsKindRepository;
    @Override
    public NewsKind findNewsByNewKindId(Integer newKindId) {
        return newsKindRepository.findAllByNewsKindId(newKindId);
    }
}
