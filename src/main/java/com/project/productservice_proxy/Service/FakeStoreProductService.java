package com.project.productservice_proxy.Service;

import com.project.productservice_proxy.DTO.ProductDto;
import com.project.productservice_proxy.Models.Categories;
import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.Service.iProductService;
import com.project.productservice_proxy.clients.IClientProductDto;
import com.project.productservice_proxy.clients.fakestore.Client.FakeStoreClient;
import com.project.productservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.lang.Nullable;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Service
public class FakeStoreProductService {
    /*
    RestTemplateBuilder restTemplateBuilder;
    FakeStoreClient fakeStoreClient;
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient)
    {
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }

    ///customr requestforEntity

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    @Override
    public List<Product> getAllProducts()
    {
//        This is moved to CLient
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<Product> product=restTemplate.getForEntity("https://fakestoreapi.com/products", Product.class);
//        return product.getBody();

        List<FakeStoreProductDto> fakeStoreProductDto=fakeStoreClient.getAllProduct();
        List<Product> product=new ArrayList<>();
        for(FakeStoreProductDto fpk:fakeStoreProductDto)
        {
            Product product1=new Product();
            product1.setId(fpk.getId());
            product1.setTitle(fpk.getTitle());
            product1.setPrice(fpk.getPrice());
            product1.setImageUrl(fpk.getImage());
            Categories categories=new Categories();
            categories.setName(fpk.getCategory());
            product1.setCategory(categories);
            product1.setDescription(fpk.getDescription());
            product.add(product1);
        }
        return product;

    }

    @Override
    public Product getSingleProduct(Long productId)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDto=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);

        Product product = getProduct(productDto.getBody());
        return product;
    }

    private static Product getProduct(FakeStoreProductDto productDto) {
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category=new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        return product;
    }

//    @Override
//    public Product addNewProduct(IClientProductDto productDto)
//    {
////       RestTemplate restTemplate=restTemplateBuilder.build();
////       restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);
//       Product product=getProduct((FakeStoreProductDto) productDto);
//       return product;
//    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product)
    {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setId(product.getId());
        //fakeStoreProductDto.setCategory(product.getCategory().getName());
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity
                =requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId);
        FakeStoreProductDto fakeStoreProductDto1=fakeStoreProductDtoResponseEntity.getBody();
        return getProduct(fakeStoreProductDto1);
    }
    @Override
    public void deleteProduct(Long productId)
    {

//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=
//                requestForEntity(HttpMethod.DELETE,
//                        "https://fakestoreapi.com/products",
//                         productId,
//                        FakeStoreProductDto.class, productId);
//        FakeStoreProductDto fakeStoreProductDto=fakeStoreProductDtoResponseEntity.getBody();
//
//        Product product=new Product();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setImageUrl(fakeStoreProductDto.getImage());
//        Categories categories=new Categories();
//        categories.setName(fakeStoreProductDto.getCategory());
//        product.setCategory(categories);
//        return product;
        System.out.println("entering to service");
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete("https://fakestoreapi.com/products/{id}", productId);
            System.out.println("deleted the product with Id"+productId);

    }

     */

}
