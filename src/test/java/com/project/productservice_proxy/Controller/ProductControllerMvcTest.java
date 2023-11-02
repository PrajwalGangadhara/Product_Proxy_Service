package com.project.productservice_proxy.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.productservice_proxy.DTO.ProductDto;
import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.Service.iProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    iProductService productService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getAllProducts() throws Exception
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());

        when(productService.getAllProducts()).thenReturn(products);

        ArrayList<ProductDto> productDto = new ArrayList<>();
        productDto.add(new ProductDto());
        productDto.add(new ProductDto());
        productDto.add(new ProductDto());

        mockMvc.perform(get("/products")).andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productDto)));
    }


}
