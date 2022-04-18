package top.qiuming.likesys.Utils;

import org.springframework.stereotype.Component;

@Component
public class GeneRandoms{
    int default_n = 6;
    public String generate(int n){
        StringBuffer stringBuffer =new StringBuffer();
        for(int i=0;i<n;i++){
            int tmp = (int) (Math.random()*10);
            stringBuffer.append(tmp);
        }
        return stringBuffer.toString();
    }
    public String generate(){
        return generate(default_n);
    }
}

