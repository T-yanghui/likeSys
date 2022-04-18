package top.qiuming.likesys.Services;

import top.qiuming.likesys.Entity.proProject;

import java.util.List;

public interface mysqlService {
    void saveVotes(proProject project);
    List<proProject> findProjectValid(Integer expire_time);
}
