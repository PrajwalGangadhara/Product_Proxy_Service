package com.project.productservice_proxy.clients.fakestore.Client;

import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoreClientTest {
    @Autowired
    FakeStoreClient fakeStoreClient;

    @Test
    public void Test_Getallproduct_ReturnAllproduct()
    {
        List<FakeStoreProductDto> productList=fakeStoreClient.getAllProduct();
        assertNotNull(productList);
        System.out.println("debug");
    }

}