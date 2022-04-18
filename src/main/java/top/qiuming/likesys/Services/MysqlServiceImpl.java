package top.qiuming.likesys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.qiuming.likesys.Dao.mysqlRepository;
import top.qiuming.likesys.Entity.proProject;

import java.util.List;

@Component(value = "mysqlService")
public class MysqlServiceImpl implements mysqlService{
    @Autowired
    mysqlRepository mysqlrepository;
    @Override
    public void saveVotes(proProject project){
        mysqlrepository.setVotes(project);
    }

    @Override
    public List<proProject> findProjectValid(Integer expire_time) {
       return mysqlrepository.findproProjectValid(expire_time);
    }
}
