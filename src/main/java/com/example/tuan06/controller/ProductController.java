package com.example.tuan06.controller;


import com.example.tuan06.model.Product;
import com.example.tuan06.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> lst = productRepository.findAll();
        return ResponseEntity.ok(lst);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productRepository.findById(id);
    }

}
