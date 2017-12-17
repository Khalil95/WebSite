package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslationEntity, Integer> {

    String REQUEST = "select c.label from CategoryTranslationEntity c where c.categoryEntity.id = :idcat and c.languageEntity.id = :idlang";


    @Query(REQUEST)
    public String findNameCategoryByLanguage(@Param("idcat") Integer idcat, @Param("idlang")Integer idlang);


}







