package top.qiuming.likesys.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component(value = "voteService")
public class voteServiceImpl implements voteService{
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    Environment en;
    //private Integer expire_time=en.getProperty("customer.expire.time",Integer.class,10);
    @Override
    public Long addVote(String key,String member) {
        Integer expire_time=en.getProperty("customer.expire.time",Integer.TYPE,10);
        String redisKey="vote:"+key;
        /*
            先判断是否有相应set
            如果没有，创建并设置过期时间
        * */
        if(!redisTemplate.hasKey(redisKey)){
            redisTemplate.opsForSet().add(redisKey,member);
            redisTemplate.expire(redisKey,expire_time, TimeUnit.DAYS);
        }else {
            /*先判断uniqueid是否存在，存在则删除，表示取消点赞*/
            Boolean isExisted = redisTemplate.opsForSet().isMember(redisKey, member);
            if (isExisted) {
                redisTemplate.opsForSet().remove(redisKey, member);
            } else {
                redisTemplate.opsForSet().add(redisKey, member);
            }
        }
        return redisTemplate.opsForSet().size(redisKey);
    }

    @Override
    public Long getVote(String key) {
        return null;
    }
}
