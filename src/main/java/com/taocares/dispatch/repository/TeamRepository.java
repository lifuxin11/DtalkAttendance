package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Institution;
import com.taocares.dispatch.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 班组Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    /**
     * 根据服务区域id分页查询班组
     */
    @Query("SELECT t from Team t where areaId = :id OR :id = null")
    Page<Team> findAll(@Param("id") Integer id, Pageable pageable);

    /**
     * 根据服务区域id查询班组
     */
    @Query("SELECT t from Team t where areaId = :id OR :id = null")
    List<Team> findAll(@Param("id") Integer id, Sort sort);
}
