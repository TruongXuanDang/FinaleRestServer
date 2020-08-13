package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productService.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product)
    {
        productService.saveProduct(product);
        System.out.println(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/sell")
    public List<Product> sellProduct(@RequestParam(name="quantity",required = true) int quantity,@RequestParam(name="id",required = true) int id)
    {
        Product product = productService.findProductById(id).get();
        int newQuantity = product.getQuantity()-quantity;
        product.setQuantity(newQuantity);
        productService.saveProduct(product);
        return productService.getAll();
    }
}
