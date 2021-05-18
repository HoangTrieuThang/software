package com.example.software.services;

import com.example.software.dto.NewsCreateRequest;
import com.example.software.model.News;
import com.example.software.model.NewsKind;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Repository
public interface NewsService {
    List<News> getAllNews();

    Page<News> listNews(PageRequest pageRequest, String title);

    NewsKind findNewsByNewsId (Integer newsId);

    News create(News news,MultipartFile file);

    News update(Integer id, News news,MultipartFile file) throws Exception;

    void delete(Integer id);

//    List<News> getNewsByDate();
//String storeFile(MultipartFile file);

    public Resource loadFileAsResource(String fileName);

//    News create(NewsCreateRequest newsCreateRequest);
}
