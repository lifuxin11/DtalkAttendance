package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Institution;
import com.taocares.dispatch.entity.InstitutionState;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 班制状态Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface InstitutionStateRepository extends JpaRepository<InstitutionState,Integer>{

    /**
     * 删除班制状态
     *
     * @param institutionId
     * @return void
     */
    void deleteByInstitutionId(Integer institutionId);

    /**
     * 查询班制状态
     *
     * @param institutionId
     * @return void
     */
    List<InstitutionState> findByInstitutionId(Integer institutionId, Sort sort);
}
