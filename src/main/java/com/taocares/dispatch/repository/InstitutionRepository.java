package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 班制Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Integer>{
}
