package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product saveProduct(Product product){
        return  productRepo.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return  productRepo.saveAll(products);
    }

    public List<Product> getProducts(){
        return  productRepo.findAll();
    }

    public Product getProductById(int id){
        return  productRepo.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return  productRepo.findByName(name);
    }


    public String  deleteProduct(int id){
        productRepo.deleteById(id);
        return  "Product Removed Successfully "+ id;
    }

    public Product updateProduct(Product product){
        int id = product.getId();
        Product existingProduct = productRepo.findById(id).orElse(null);
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        return productRepo.save(existingProduct);



    }










}


