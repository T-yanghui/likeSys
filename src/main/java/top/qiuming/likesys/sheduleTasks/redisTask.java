package top.qiuming.likesys.sheduleTasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import top.qiuming.likesys.Entity.proProject;
import top.qiuming.likesys.Services.mysqlService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class redisTask {
    @Autowired
    mysqlService mysqlService;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    Environment env;
    @Scheduled(cron="* */30 * * * ?")
    private void redisWriteVoteToSQL(){
        Integer expire_time=env.getProperty("customer.expire.time",Integer.TYPE,10);
        List<proProject> list=mysqlService.findProjectValid(expire_time);
        for(proProject project:list){
            String redisKey="vote:project:"+project.getView_uuid();
            log.info("检查"+redisKey);
            //如果redis存储有，则更新数据库
            if(redisTemplate.hasKey(redisKey)){
                Integer redisCount=Integer.parseInt(redisTemplate.opsForSet().size(redisKey).toString());
                if(redisCount!=project.getVotes()) {
                    log.info("更新"+redisKey+" from "+project.getVotes()+" to "+redisCount);
                    project.setVotes(redisCount);
                    mysqlService.saveVotes(project);
                }
            }
        }
    }
}
