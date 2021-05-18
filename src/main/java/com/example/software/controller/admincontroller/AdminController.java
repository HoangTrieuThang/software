package com.example.software.controller.admincontroller;

import com.example.software.model.Admin;
import com.example.software.model.NewsKind;
import com.example.software.repository.NewsKindRepository;
import com.example.software.services.AdminAccountService;
import com.example.software.services.AdminService;
import com.example.software.services.NewsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("adminController")
@RequestMapping("/api/admin/account")
@CrossOrigin(origins = {"*"})
public class AdminController {
    @Autowired
    private AdminAccountService adminAccountService;

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdminAccount(@RequestBody Admin admin) {
        Admin admin1 = adminAccountService.create(admin);
        return ResponseEntity.status(201).body(admin1);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdminAccount(@PathVariable Integer id,
                                                   @RequestBody Admin admin) throws Exception {
        Admin admim1 = adminAccountService.update(id, admin);
        return ResponseEntity.status(200).body(admim1);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Admin> deleteAdminAccount(@PathVariable Integer id) {
        adminAccountService.delete(id);
        return ResponseEntity.status(200).body(null);
    }
    @GetMapping("/getList")
    public List<Admin> getListAccount() {
        return adminAccountService.getAll();
    }
}
