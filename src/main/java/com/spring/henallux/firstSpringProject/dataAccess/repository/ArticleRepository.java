package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

    String REQUEST = "update ArticleEntity a set a.quantityStock = a.quantityStock - :qty where a.id = :idart";


    @Modifying
    @Query(REQUEST)
    public void updateQuantityArticle(@Param("idart") Integer id, @Param("qty")Integer qty);


}
