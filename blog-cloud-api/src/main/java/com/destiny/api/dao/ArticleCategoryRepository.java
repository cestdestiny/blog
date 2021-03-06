package com.destiny.api.dao;

import com.destiny.api.domain.pojo.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory,Integer> {
    /**
     * 根据类型type和状态status查询
     *
     * @return
     */
    @Query("select a from ArticleCategory a  where a.status = :status and a.type = :type")
    List<ArticleCategory> findByTypeAndStatus(@Param("status") Integer status, @Param("type") Integer type);

}
