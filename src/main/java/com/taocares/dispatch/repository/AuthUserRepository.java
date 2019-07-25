package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.AuthUser;
import com.taocares.dispatch.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,Integer>{
}
