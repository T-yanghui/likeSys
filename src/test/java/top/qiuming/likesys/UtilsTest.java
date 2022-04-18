package top.qiuming.likesys;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.qiuming.likesys.Utils.TokenUtil;
@Slf4j
@SpringBootTest
public class UtilsTest {
    @Autowired
    private TokenUtil tokenUtil;
    @Test
    public void testToken(){
        String token=tokenUtil.getProjectToken("yang","123");
        log.info(token);
        log.info(String.valueOf(tokenUtil.verifyToken(token)));
        log.info(tokenUtil.parseToken(token).get("project").toString());
    }
}
