package com.project.productservice_proxy.Controller;

import com.project.productservice_proxy.DTO.ProductDto;
import com.project.productservice_proxy.Models.Categories;
import com.project.productservice_proxy.Models.Product;
import com.project.productservice_proxy.Security.JwtObject;
import com.project.productservice_proxy.Security.TokenValidator;
import com.project.productservice_proxy.Service.FakeStoreProductService;
import com.project.productservice_proxy.clients.IClientProductDto;
import com.project.productservice_proxy.Service.iProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    iProductService productService;
    TokenValidator tokenValidator;
    public ProductController(iProductService productService, TokenValidator tokenValidator)
    {
        this.productService=productService;
        this.tokenValidator=tokenValidator;
    }
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
        List<Product> product=productService.getAllProducts();
        List<ProductDto> pdto=new ArrayList<>();
        for(Product tempProduct:product)
        {
            pdto.add(getProductDto(tempProduct));
        }
        ResponseEntity<List<ProductDto>> response=new ResponseEntity<>(pdto, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getSingleProduct(@Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
                                                       @PathVariable("id") Long productId)
    {
        try {
            JwtObject authTokenObj=null;
            if(authToken != null)
            {
                Optional<JwtObject> authObjectOptional=tokenValidator.validateToken(authToken);
                if(authObjectOptional.isEmpty())
                {
                    //throw exception
                }
                authTokenObj=authObjectOptional.get();
            }
            MultiValueMap<String, String> headers=new LinkedMultiValueMap<>();
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");
            headers.add("auth-token", "heyaccess");
            Product product = productService.getSingleProduct(productId);
            ProductDto productDto=getProductDto(product);
            if(productId<1)
            {
                throw new IllegalArgumentException("invalid id");
            }
            ResponseEntity<ProductDto> responseEntity = new ResponseEntity<>(productDto, headers, HttpStatus.OK);
            return responseEntity;
        }
        catch(Exception e)
        {
            //ResponseEntity<Product> responseEntity= new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            //return responseEntity;
            throw e;
        }
    }
    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto)
    {
        Product product=getProduct(productDto);
        Product savedProduct=productService.addNewProduct(product);
        ResponseEntity<Product> response=new ResponseEntity<>(savedProduct, HttpStatus.OK);
        return response;

    }

    @PatchMapping("/{productId}")
    public Product patchProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto)
    {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        //product.setCategory(productDto.getCategory());
        return this.productService.updateProduct(productId, product);
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId)
    {
        return "updated product with id : "+productId;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId)
    {
        productService.deleteProduct(productId);
        return "delete product with Id : "+productId;
    }
    private static Product getProduct(ProductDto productDto) {
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

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<String> exceptionHandler(Exception e)
    {
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
