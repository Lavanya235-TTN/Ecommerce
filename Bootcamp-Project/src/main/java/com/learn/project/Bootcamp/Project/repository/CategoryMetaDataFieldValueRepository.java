package com.learn.project.Bootcamp.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.project.Bootcamp.Project.model.Products.CategoryMetadataFieldValue;

public interface CategoryMetaDataFieldValueRepository extends JpaRepository<CategoryMetadataFieldValue, Long> {
    CategoryMetadataFieldValue findCategoryMetadataFieldValueByValue(String s);

    CategoryMetadataFieldValue findCategoryMetadataFieldValueById(Long id);
}
