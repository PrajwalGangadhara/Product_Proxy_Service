package com.project.productservice_proxy.Service;

import com.project.productservice_proxy.DTO.ProductDto;
import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.clients.IClientProductDto;

import java.util.List;

public interface iProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);



    Product addNewProduct(Product product);

    Product updateProduct(Long productId, Product product);

    void deleteProduct(Long productId);
}
