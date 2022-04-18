package top.qiuming.likesys;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import top.qiuming.likesys.Controllers.mainController;
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class mainControllerTest{

    @Autowired
    private MockMvc mock;
    @Test
    void mainContollerTEst() {
        MvcResult res1=null;
        MvcResult res2=null;
        //String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmY2M1YmZlMS0zZDU2LTQ0N2EtYjg4Mi0xYjc1YzE3ZTVmYmYiLCJpYXQiOjE2NTAxODQ3NDAsImV4cCI6MTY1MTA0ODc0MCwicHJvamVjdCI6InlhbmciLCJ1bmlxdWVJRCI6IjEyMyJ9.wQvV9hLd2ncsBSo3a5kSm56_Tsrxvv0c2RGzF-_1524";
        try {
            res1 = mock.perform(MockMvcRequestBuilders.get("/getToken")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("project","231"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andReturn();
            String token=res1.getResponse().getContentAsString();
            log.info("token: "+token);

            res2 = mock.perform(MockMvcRequestBuilders.get("/getVotes")
                    .accept(MediaType.APPLICATION_JSON)
                    .param("token",token))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            log.info(res2.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
