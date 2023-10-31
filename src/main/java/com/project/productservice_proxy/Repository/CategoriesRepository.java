package com.project.productservice_proxy.Repository;

import com.project.productservice_proxy.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Categories save(Categories categories);

    Categories findById(long Id);
}
