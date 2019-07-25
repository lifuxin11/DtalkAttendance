package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Leave;
import com.taocares.dispatch.entity.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 请假记录Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface LeaveRepository extends JpaRepository<Leave,Integer>{

}
