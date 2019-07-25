package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Institution;
import com.taocares.dispatch.entity.SrvcArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 服务区域Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface SrvcAreaRepository extends JpaRepository<SrvcArea,Integer>{
}
