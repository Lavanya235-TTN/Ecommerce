package com.learn.project.Bootcamp.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.project.Bootcamp.Project.model.Products.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Category findCategoryById(Long id);

    List<Category> findCategoriesByCategoryId(Long id);
}
