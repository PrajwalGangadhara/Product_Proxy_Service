package com.project.productservice_proxy.Repository;

import com.project.productservice_proxy.Models.Categories;
import com.project.productservice_proxy.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    ProductRepository productRepository;
    @Test
    //@Transactional
    void saveproduct() {
        Categories categories=new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics");
        categoriesRepository.save(categories);

        Product product=new Product();
        product.setTitle("Laptop");
        product.setPrice(10000.0);
        product.setCategory(categories);

        productRepository.save(product);

        Categories categories1=categoriesRepository.findById(categories.getId()).get();
        List<Product> productList = categories1.getProductList();
        System.out.println("debug");
    }

    @Test
        //@Transactional
    void saveProductsAndCategory2() {
        Categories categories = new Categories();
        categories.setName("Fashion");
        categories.setDescription("Fashion");
        //categories = categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Tshirt");
        product.setDescription("Tshirt");
        product.setCategory(categories);
        productRepository.save(product);

        //Categories categories1 = categoryRepo.findById(categories.getId()).get();
        //List<Product> productList = categories1.getProductList();
        System.out.println("Debug");

    }

    @Test
    @Transactional
    void saveProductsAndCategory1() {
        Product product = new Product();
        product.setTitle("Laptop");
        product.setDescription("Laptop");
        productRepository.save(product);

        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics");
        categories.setProductList(List.of(product));
        categories = categoriesRepository.save(categories);

        Categories categories1 = categoriesRepository.findById(categories.getId()).get();
        List<Product> productList = categories1.getProductList();
        System.out.println("Debug");

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductsAndCategory3() {
        Categories category = categoriesRepository.findById(352L);
        List<Product> productList = category.getProductList();
        for (Product product : productList) {
            System.out.println(product.getPrice());
        }


//        Product product = new Product();
//        product.setPrice(1012);
//        product.setImageUrl("television");
//        product.setCategory(category);
//        Product savedProduct = productRepository.save(product);
//
//        product = new Product();
//        product.setPrice(103);
//        product.setImageUrl("refrigerator");
//        product.setCategory(category);
//        productRepository.save(product);


    }

    @Test
    public void demo()
    {
        Categories categories=categoriesRepository.findById(202L);
        System.out.println(categories.getName());
    }


}