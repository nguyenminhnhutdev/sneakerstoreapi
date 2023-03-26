package com.aptech.api.controller;

import com.aptech.api.entity.Product;
import com.aptech.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.listAll();
    }

    @GetMapping("/get")
    public ResponseEntity<Product> get(@RequestParam(name = "id") int id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product, @RequestParam(name = "id") Integer id) {
        try {
            Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam(name = "id") int id) {
        service.delete(id);
    }
}
