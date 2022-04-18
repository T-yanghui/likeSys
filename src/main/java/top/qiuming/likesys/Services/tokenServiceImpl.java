package top.qiuming.likesys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class tokenServiceImpl implements tokenService{
    @Autowired
    StringRedisTemplate redisTemplate;
    @Override
    public String getUniqueID(String key) {
        String redisKey="project:"+key;
        if(!redisTemplate.hasKey(redisKey)){
            redisTemplate.opsForValue().set(redisKey,"0");
        }else{
            redisTemplate.opsForValue().increment(redisKey);
        }
        return redisTemplate.opsForValue().get(redisKey);
    }
}
