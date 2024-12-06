package org.lester.springbootlearn.jpalearn.controllers;

import org.lester.springbootlearn.jpalearn.entities.Product;
import org.lester.springbootlearn.jpalearn.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "")
    public ResponseEntity<?> getProducts(@RequestParam(defaultValue = "id") String sortBy) {
        List<Product> res = productRepository.findBy(Sort.by(sortBy));
        System.out.println(res);
        return ResponseEntity.ok(res);
    }

    @GetMapping(path = "/pagi")
    public ResponseEntity<?> getProductsPagi(
            @RequestBody String title,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<Product> res = productRepository.findByTitle(title, pageable);
        System.out.println(res);
        return ResponseEntity.ok(res.getContent());
    }
}
