package com.example.software.services;

import com.example.software.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewRpository {
    List<News> findAllNew();
}
