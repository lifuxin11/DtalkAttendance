package com.taocares.dispatch.repository;

import com.taocares.dispatch.entity.Attendance;
import com.taocares.dispatch.entity.Team;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 考勤Repository
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    /**
     * 根据服务区域id、用户名、开始日期、结束日期查询考勤
     */
    @Query("SELECT distinct a from Attendance a left join UserTeam ut on a.userId = ut.userId " +
            "left join Team t on ut.teamId = t.id " +
            "left join AuthUser au on a.userId = au.id  where (t.areaId = :id OR :id = null) and (au.name = :name OR :name = null)" +
            "and (a.date >= :startDate OR :startDate = null) and (a.date <= :endDate OR :endDate = null)")
    List<Attendance> findAttendance(@Param("id") Integer id, @Param("name") String name, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /**
     * 根据用户id、日期查询考勤
     */
    Attendance findByUserIdAndDate(Integer userId, Date date);
}
