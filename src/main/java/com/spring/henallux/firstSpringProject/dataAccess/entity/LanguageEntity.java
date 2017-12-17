package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="language")
public class LanguageEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="languageEntity")
    private Collection<CategoryTranslationEntity> categoryTranslationEntityCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CategoryTranslationEntity> getCategoryTranslationEntityCollection() {
        return categoryTranslationEntityCollection;
    }

    public void setCategoryTranslationEntityCollection(Collection<CategoryTranslationEntity> categoryTranslationEntityCollection) {
        this.categoryTranslationEntityCollection = categoryTranslationEntityCollection;
    }
}
