package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy="categoryEntity")
    private Collection<CategoryTranslationEntity> categoryTranslationEntityCollection;

    public Collection<CategoryTranslationEntity> getCategoryTranslationEntityCollection() {
        return categoryTranslationEntityCollection;
    }

    public void setCategoryTranslationEntityCollection(Collection<CategoryTranslationEntity> categoryTranslationEntityCollection) {
        this.categoryTranslationEntityCollection = categoryTranslationEntityCollection;
    }


}
