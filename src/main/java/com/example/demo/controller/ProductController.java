package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    /* @GetMapping("/test")
    public Map<String ,Object> getTest(){
        Map map = new HashMap();
        map.putIfAbsent("Name", "Abdullah");
        map.putIfAbsent("Sec", "C");


        Map courseMap = new HashMap();
        courseMap.putIfAbsent("title","Data Structure & Algorithm");
        courseMap.putIfAbsent("credit",3);
        courseMap.putIfAbsent("price",4500);
        map.putIfAbsent("course",courseMap);
        return map;
    }*/



    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return  service.saveProduct(product);
    }

}
