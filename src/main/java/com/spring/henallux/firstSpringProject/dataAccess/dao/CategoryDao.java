package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.converter.ProviderConverterCategory;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.firstSpringProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDao {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProviderConverterCategory providerConverterCategory;

    @Autowired
    private CategoryTranslationRepository categoryTranslationRepository;

    public List<Category> getCategories(String locale)
    {
        int codeLanguage = 1;

        if(locale.equals("fr"))
            codeLanguage = 2;

        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<Category> categoryArrayList = new ArrayList<>();

        for(CategoryEntity categoryEntity : categoryEntities)
        {
            Category category = providerConverterCategory.categoryEntityToCategoryModel(categoryEntity);
            category.setName(categoryTranslationRepository.findNameCategoryByLanguage(category.getId(), codeLanguage));
            System.out.println(" bd nom cat : "+category.getName());
            categoryArrayList.add(category);
        }

        return categoryArrayList;
    }

}