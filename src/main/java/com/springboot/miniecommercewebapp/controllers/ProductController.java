package com.springboot.miniecommercewebapp.controllers;

import com.springboot.miniecommercewebapp.models.Product;
import com.springboot.miniecommercewebapp.models.ResponseObject;
import com.springboot.miniecommercewebapp.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    // Get all products
    @GetMapping("")
    List<Product> getAllProducts() {
        return iProductService.getAllProducts();
    }

    // Get products by category id
    @GetMapping("getProductsByCateId/{categoryId}")
    ResponseEntity<ResponseObject> getProductsByCategoryId(@PathVariable int categoryId) {
        return iProductService.getProductsByCategoryId(categoryId);
    }

    //
//    // Get detail product by id
    @GetMapping("/getProductById/{productId}")
    ResponseEntity<ResponseObject> getProductById(@PathVariable int productId) {
        return iProductService.getProductDetailById(productId);
    }

    // Add product
    @PostMapping("/addNewProduct")
    ResponseEntity<ResponseObject> addNewProduct(@RequestBody Product newProduct) {
        return iProductService.addNewProduct(newProduct);
    }
    // Update Product
    @PutMapping("updateProduct/{productId}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable int productId)
    {
        return iProductService.updateProduct(newProduct, productId);
    }
    // Delete product by id
    @DeleteMapping("/deleteProduct/{productId}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable int productId)
    {
        return iProductService.deleteProduct(productId);
    }

}