package top.qiuming.likesys.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.qiuming.likesys.Utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class doVoteInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil;
    /*
        验证token
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getParameter("token");
        if(token==null) return false;
        if(tokenUtil.verifyToken(token)==0){
            Map<String,Object> map= tokenUtil.parseToken(token);
            String project=map.get("project").toString();
            String uniqueID=map.get("uniqueID").toString();
            request.setAttribute("project",project);
            request.setAttribute("uniqueID",uniqueID);
            return true;
        }
        return false;
    }
}
