package com.learn.project.Bootcamp.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.project.Bootcamp.Project.model.Products.CategoryMetaData;

public interface CategoryMetadataRepository extends JpaRepository<CategoryMetaData, Long> {

    CategoryMetaData findByName(String s);

    CategoryMetaData findCategoryMetaDataById(Long id);
}
