//package com.example.software.controller.admincontroller;
//
//import com.example.software.model.Admin;
//import com.example.software.model.NewsKind;
//import com.example.software.repository.NewsKindRepository;
//import com.example.software.services.AdminAccountService;
//import com.example.software.services.AdminService;
//import com.example.software.services.NewsKindService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController("adminController")
//@RequestMapping("/api/admin/account")
//@CrossOrigin(origins = {"*"})
//public class AdminController {
//    @Autowired
//    private AdminAccountService adminAccountService;
//
//    @PostMapping("/create")
//    public ResponseEntity<NewsKind> createAdminAccount(@RequestBody Admin admin) {
//        NewsKind newsKind1 = adminAccountService.create(admin);
//        return ResponseEntity.status(201).body(newsKind1);
//    }
//
//    @PostMapping("/update/{id}")
//    public ResponseEntity<NewsKind> updateAdminAccount(@PathVariable Integer id,
//                                                   @RequestBody Admin admin) throws Exception {
//        NewsKind newsKind1 = adminAccountService.update(id, newsKind);
//        return ResponseEntity.status(200).body(newsKind1);
//    }
//
//    @PostMapping("/delete/{id}")
//    public ResponseEntity<NewsKind> deleteAdminAccount(@PathVariable Integer id) {
//        adminAccountService.delete(id);
//        return ResponseEntity.status(200).body(null);
//    }
//    @GetMapping("/getList")
//    public List<NewsKind> getListAccount() {
//        return adminAccountService.findAll();
//    }
//}
