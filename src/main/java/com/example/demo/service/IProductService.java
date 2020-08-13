package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> getAll();
    public void saveProduct(Product product);
    public Optional<Product> findProductById(int id);
}
