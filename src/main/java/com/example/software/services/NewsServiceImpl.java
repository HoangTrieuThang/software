package com.example.software.services;

import com.example.software.model.News;
import com.example.software.model.NewsKind;
import com.example.software.repository.NewsRepository;
import com.example.software.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@Repository
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @PersistenceContext
    private EntityManager em;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public Page<News> listNews(PageRequest pageRequest, String title) {
        return null;
    }

    @Override
    public NewsKind findNewsByNewsId(Integer newsId) {
        return null;
    }

    @Override
    public News create(News news) {
        return null;
    }

    @Override
    public News update(Integer id, News news) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
