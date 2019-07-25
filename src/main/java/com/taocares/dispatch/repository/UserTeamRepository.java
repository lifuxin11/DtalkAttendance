package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Team;
import com.taocares.dispatch.entity.UserTeam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户班组Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam,Integer>{

}
