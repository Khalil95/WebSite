package com.spring.henallux.firstSpringProject.dataAccess.converter;


import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverterCategory {


    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }

}
