package com.example.software.services.impl;

import com.example.software.model.NewsKind;
import com.example.software.repository.AdminAccountRepository;
import com.example.software.services.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountServiceImpl implements AdminAccountService {
    @Autowired
    private AdminAccountRepository adminAccountRepository;
    @Override
    public NewsKind findNewsByNewKindId(Integer newKindId) {
        return null;
    }

    @Override
    public NewsKind create(NewsKind newsKind) {
        return null;
    }

    @Override
    public NewsKind update(Integer id, NewsKind newsKind) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
