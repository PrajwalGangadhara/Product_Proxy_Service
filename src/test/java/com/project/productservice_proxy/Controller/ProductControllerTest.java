package com.project.productservice_proxy.Controller;

import com.project.productservice_proxy.DTO.ProductDto;
import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.Service.iProductService;
import jakarta.persistence.Converter;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import javax.management.RuntimeErrorException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean
    iProductService productService;

    @Test
    public void test_whenGetProductIscalled_ReturnProduct()
    {
        //Mocking the dependency behaviour(ProductService)
        when(productService.getSingleProduct(any(Long.class))).thenReturn(new Product());

       ResponseEntity<ProductDto> productResponseEntity= productController.getSingleProduct(1l);
       assertNotNull(productResponseEntity.getBody());
    }

        @Test
    public void test_whenGetProductIscalled_ThrowException()
    {
        when(productService.getSingleProduct(any(Long.class))).
                thenThrow(new RuntimeException("something went wrong"));

        //ResponseEntity<ProductDto> productResponseEntity=productController.getSingleProduct(1l);
        assertThrows(RuntimeException.class, ()->productController.getSingleProduct(1l));
    }

    @Test
    public void test_WhenAddproductIsCalled_ReturnProduct()
    {
        //Creating product to be added
        Product productTObeadded=new Product();
        productTObeadded.setTitle("UnitTest");
        productTObeadded.setPrice(100.0);

        //Creating expected Product
        Product expectedproduct=new Product();
        expectedproduct.setId(2l);
        expectedproduct.setTitle("UnitTest");
        expectedproduct.setPrice(100.0);

        //Setting mock rule
        when(productService.addNewProduct(any(Product.class))).thenReturn(expectedproduct);
        ResponseEntity<Product> returnedProduct=productController.addProduct(getProductDto(productTObeadded));
        assertEquals(expectedproduct, returnedProduct.getBody());
        assertEquals(expectedproduct.getTitle(), returnedProduct.getBody().getTitle());
        System.out.println("debug");
    }

    private static ProductDto getProductDto(Product product)
    {
        ProductDto productDto=new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setRating(productDto.getRating());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImageUrl());
        return productDto;
    }
}