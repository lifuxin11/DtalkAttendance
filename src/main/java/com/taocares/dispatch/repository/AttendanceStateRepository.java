package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.AttendanceState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 考勤状态Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface AttendanceStateRepository extends JpaRepository<AttendanceState,Integer>{

}
