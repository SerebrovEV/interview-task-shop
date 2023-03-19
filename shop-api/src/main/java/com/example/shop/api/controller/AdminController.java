package com.example.shop.api.controller;

import com.example.shop.api.dto.ProdactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @PostMapping
    public ResponseEntity<String> example(@RequestBody ProdactDto prodactDto,
                                          Authentication authentication) {
        return ResponseEntity.ok(authentication.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Long> example2(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }


}
