package com.example.software.controller.admincontroller;

import com.example.software.model.NewsKind;
import com.example.software.repository.NewsKindRepository;
import com.example.software.services.NewsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("adminNewsKindController")
@RequestMapping("/api/admin/news-kind")
@CrossOrigin(origins = {"*"})
public class NewsKindController {

    @Autowired
    private NewsKindService newsKindService;

    @Autowired
    private NewsKindRepository newsKindRepository;

    @PostMapping("/create")
    public ResponseEntity<NewsKind> createNewsKind(@RequestBody NewsKind newsKind) {
        NewsKind newsKind1 = newsKindService.create(newsKind);
        return ResponseEntity.status(201).body(newsKind1);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<NewsKind> createNewsKind(@PathVariable Integer id,
                                                   @RequestBody NewsKind newsKind) throws Exception {
        NewsKind newsKind1 = newsKindService.update(id, newsKind);
        return ResponseEntity.status(200).body(newsKind1);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<NewsKind> deleteNewsKind(@PathVariable Integer id) {
        newsKindService.delete(id);
        return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/getPage")
    public ResponseEntity<Page<NewsKind>> getAll(@RequestParam Optional<Integer> pageIndex,@RequestParam Optional<Integer> pageSize,@RequestParam Optional<String> newsKindName) {
        Page<NewsKind> newsKinds = newsKindService.listNewsKind( PageRequest.of(pageIndex.orElse(0),pageSize.orElse(10),Sort.by(Sort.Direction.ASC,"news_kind_id")),newsKindName.orElse("_"));
        return ResponseEntity.status(200).body(newsKinds);
    }
    @GetMapping("/getList")
    public List<NewsKind> getListNewsKind() {
        return newsKindRepository.findAll();
    }
}
