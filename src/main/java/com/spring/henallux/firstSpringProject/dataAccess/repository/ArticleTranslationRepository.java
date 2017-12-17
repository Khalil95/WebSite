package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ArticleTranslationRepository extends JpaRepository<ArticleEntity, Integer> {


    String REQUEST = "select a.description from ArticleTranslationEntity a where a.articleEntity.id = :idart and a.languageEntity.id = :idlang";

    String REQUESTNAME = "select a.name from ArticleTranslationEntity a where a.articleEntity.id = :idart and a.languageEntity.id = :idlang";

    @Query(REQUEST)
    public String findReferenceArticleByLanguage(@Param("idart") Integer idcat, @Param("idlang")Integer idlang);


}
