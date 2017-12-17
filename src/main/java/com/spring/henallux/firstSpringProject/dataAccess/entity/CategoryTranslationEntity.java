package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="categorytranslation")
public class CategoryTranslationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="label")
    private String label;


    @JoinColumn(name="idCategory",referencedColumnName="id")
    @ManyToOne
    private CategoryEntity categoryEntity;

    @JoinColumn(name="idLanguage",referencedColumnName="id")
    @ManyToOne
    private LanguageEntity languageEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public LanguageEntity getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntity = languageEntity;
    }
}
