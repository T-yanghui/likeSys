package top.qiuming.likesys;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.qiuming.likesys.Entity.proProject;
import top.qiuming.likesys.Services.mysqlService;

import java.util.List;

@SpringBootTest
@Slf4j
public class mysqlServiceTest {
    @Autowired
    mysqlService service;
    @Test
    public void serviceSaveTest(){
        proProject project=new proProject();
        project.setView_uuid("2f791e3965083d94");
        project.setVotes(444);
        service.saveVotes(project);
    }
    @Test
    public void serviceFindTest(){
        List<proProject> list=service.findProjectValid(800);
        list.forEach(x->{log.info(x.toString());});
    }

}
