package top.qiuming.likesys.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.qiuming.likesys.Entity.proProject;

import javax.transaction.Transactional;
import java.util.List;

public interface mysqlRepository extends JpaRepository<proProject,Long> {
    @Transactional
    @Modifying
    @Query(value = "update u_worksmain t set t.praised_num =:#{#project.votes} where t.view_uuid=:#{#project.view_uuid}",nativeQuery = true)
    void setVotes(proProject project);

    @Query(value = "select pk_works_main,view_uuid,praised_num from u_worksmain where DATE_SUB(CURDATE(), INTERVAL ?1 DAY) <= date(create_time)",nativeQuery = true)
    List<proProject> findproProjectValid(Integer expire_time);
}
