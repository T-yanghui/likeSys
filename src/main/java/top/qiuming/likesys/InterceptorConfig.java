package top.qiuming.likesys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.qiuming.likesys.Interceptors.doVoteInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private doVoteInterceptor dovoteInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns用于添加拦截路径
        //excludePathPatterns用于添加不拦截的路径
        registry.addInterceptor(dovoteInterceptor).addPathPatterns("/getVotes");

    }
}
