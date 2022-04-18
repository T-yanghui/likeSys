package top.qiuming.likesys.Services;

public interface voteService {
    Long addVote(String key,String member);
    Long getVote(String key);
}
