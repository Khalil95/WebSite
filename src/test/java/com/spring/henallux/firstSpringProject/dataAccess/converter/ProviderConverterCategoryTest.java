package com.spring.henallux.firstSpringProject.dataAccess.converter;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProviderConverterCategoryTest {

    private ProviderConverterCategory providerConverterCategory;

    @Before
    public void setUp() throws Exception {
        providerConverterCategory = new ProviderConverterCategory();
    }

    @Test
    public void categoryEntityToCategoryModel() throws Exception {

        Category category = new Category();
        category.setId(2);
        category.setName("bibi");
        //  assertEquals(5,categorie.getid);
        assertEquals("bibi", category.getName());
        assertNotEquals("baba", category.getName());
        assertNotNull(category);
    }

}