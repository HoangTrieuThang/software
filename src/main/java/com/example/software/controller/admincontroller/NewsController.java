package com.example.software.controller.admincontroller;

import com.example.software.controller.response.UploadFileResponse;
import com.example.software.dto.NewsCreateRequest;
import com.example.software.model.News;
import com.example.software.model.NewsKind;
import com.example.software.services.NewsKindService;
import com.example.software.services.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController("adminNewsController")
@RequestMapping("/api/admin/news")
@CrossOrigin(origins = {"*"})
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsKindService newsKindService;

    @GetMapping("/getList")
    public List<News> getListNewsKind() {
        return newsService.getAllNews();
    }


    @RequestMapping(value="/create",method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public ResponseEntity<News> createNews(@RequestParam("file") MultipartFile file,
                                           @RequestParam("title") String title,
                                           @RequestParam("newsDesc") String newsDesc,
                                           @RequestParam("content") String content,
                                           @RequestParam("newsKindId") Integer newsKindId
    ){

        NewsKind newsKind = newsKindService.findNewsByNewKindId(newsKindId);
        if(newsKind !=null) {
            News news =new News();
            news.setTitle(title);
            news.setContent(content);
            news.setNewsKind(newsKind);
            news.setNewsDate(new Date());
            news.setNewsDesc(newsDesc);
            news.setLikeCount(0);
            news.setNewsDesc("test");
            News news1 = newsService.create(news,file);
            return ResponseEntity.status(200).body(news1);
        }
        return null;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Integer id,@RequestParam("title") String title,
                                           @RequestParam("content") String content,
                                           @RequestParam("newsDesc") String newsDesc,
                                           @RequestParam("newsKindId") Integer newsKindId,
                                           @RequestParam("file") MultipartFile file) throws Exception {
        NewsKind newsKind = newsKindService.findNewsByNewKindId(newsKindId);
        if(newsKind != null) {
            News news =new News();
            news.setTitle(title);
            news.setContent(content);
            news.setNewsKind(newsKind);
            news.setNewsDesc(newsDesc);
            news.setNewsDate(new Date());
            news.setLikeCount(0);
            news.setNewsDesc("test");
            News news1 = newsService.update(id,news,file);
            return ResponseEntity.status(200).body(news1);
        }
       return null;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<News> deleteNews(@PathVariable Integer id) {
        newsService.delete(id);
        return ResponseEntity.status(200).body(null);
    }

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> getImgage(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = newsService.loadFileAsResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
