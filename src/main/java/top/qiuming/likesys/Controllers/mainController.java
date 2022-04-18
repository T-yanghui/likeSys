package top.qiuming.likesys.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.qiuming.likesys.Services.tokenService;
import top.qiuming.likesys.Services.voteService;
import top.qiuming.likesys.Utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
public class mainController {
    @Autowired
    voteService voteservice;
    @Autowired
    tokenService tokenservice;
    @Autowired
    TokenUtil tokenUtil;
    @GetMapping("/getVotes")
    public Long getVotes(HttpServletRequest request){
        String project=request.getAttribute("project").toString();
        String uniqueID=request.getAttribute("uniqueID").toString();
        log.info(project+" "+uniqueID);
        Long numbers=voteservice.addVote("project:"+project,uniqueID);
        return numbers;
    }
    @GetMapping("/getToken")
    public String getVote(@RequestParam(value="project") String project){
       String uniqueID=tokenservice.getUniqueID(project);
       return tokenUtil.getProjectToken(project,uniqueID);
    }
}
