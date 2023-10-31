package com.project.productservice_proxy.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    @GetMapping("")
    public String getAllCategory()
    {

        return "all category";
    }

    @GetMapping("/{categoryId}")
    public String getAllProductsInCategory(@PathVariable("categoryId") Long CategoryId)
    {
        if(CategoryId<0)
            throw new IllegalArgumentException("invalid input");
        return "Get products in category";
    }
}
