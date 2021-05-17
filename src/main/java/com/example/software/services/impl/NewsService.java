package com.example.software.services.impl;

import com.example.software.common.CommonMapper;
import com.example.software.common.FileStorageException;
import com.example.software.common.MyFileNotFoundException;
import com.example.software.config.FileStorageProperties;
import com.example.software.dto.NewsCreateRequest;
import com.example.software.model.News;
import com.example.software.model.NewsKind;
import com.example.software.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements com.example.software.services.NewsService {
@Autowired
private NewsRepository newsRepository;

    @Override
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
    public News create(News news,MultipartFile file) {
        String fileName = "";
        if(file != null) {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                if(fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }

                Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }
        if (fileName != "" && file != null)
        news.setTitleImg("/api/admin/news/downloadFile/"+fileName);
       return newsRepository.save(news);
    }

    @Override
    @Transactional
    public News update(Integer id, News news,MultipartFile file) throws Exception {
       News news1 = newsRepository.findByNewsId(id);
        if (news1 == null) {
            throw new Exception("abc");
        }
        String fileName = "";
        if(file != null) {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                if(fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }

                Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }
        if (fileName != "" && file != null)
            news1.setTitleImg("/api/admin/news/downloadFile/"+fileName);
        news1.setTitle(news.getTitle());
        news1.setContent(news.getContent());
        news1.setNewsKind(news.getNewsKind());
        return newsRepository.save(news1);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
     newsRepository.deleteByNewsId(id);
    }
    private Path fileStorageLocation;

    @Autowired
    public NewsService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new  UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

//    @Override
//    public News create(NewsCreateRequest newsCreateRequest) {
//        News news = new News();
//        String fileName = "";
//        if(newsCreateRequest.getFile() != null) {
//            fileName = StringUtils.cleanPath(newsCreateRequest.getFile().getOriginalFilename());
//
//            try {
//                if(fileName.contains("..")) {
//                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//                }
//
//                Path targetLocation = this.fileStorageLocation.resolve(fileName);
//                Files.copy(newsCreateRequest.getFile().getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//
//            } catch (IOException ex) {
//                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//            }
//        }
//        if (fileName != "" && newsCreateRequest.getFile() != null)
//            news.setTitleImg("/api/admin/news/downloadFile/"+fileName);
//
//        news.setNewsDesc(newsCreateRequest.getNewsDesc());
//        news.setLikeCount(newsCreateRequest.getLikeCount());
//        news.setNewsDate(newsCreateRequest.getNewsDate());
//        news.setContent(newsCreateRequest.getContent());
//        news.setTitle(newsCreateRequest.getTitle());
//        news.setNewsSource(newsCreateRequest.getNewsSource());
//        news.setNewsKindId(newsCreateRequest.getNewsKindId());
//        return newsRepository.save(news);
//    }
}
