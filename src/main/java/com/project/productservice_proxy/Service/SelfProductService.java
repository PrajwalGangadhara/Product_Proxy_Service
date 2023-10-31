package com.project.productservice_proxy.Service;

import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements iProductService{

    ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
      return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) {
       Product product=productRepository.findById(productId).get();
        return product;

    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }
}
