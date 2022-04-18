package top.qiuming.likesys.Entity;




import javax.persistence.*;

@Entity
@Table(name="u_worksmain")
public class proProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_works_main;
    private String  view_uuid;
    @Column(name="praised_num")
    private int votes;

    public proProject() {
    }

    public proProject(Long pk_works_main, String view_uuid) {
        this.pk_works_main = pk_works_main;
        this.view_uuid = view_uuid;
    }

    public Long getPk_works_main() {
        return pk_works_main;
    }

    public void setPk_works_main(Long pk_works_main) {
        this.pk_works_main = pk_works_main;
    }

    public String getView_uuid() {
        return view_uuid;
    }

    public void setView_uuid(String view_uuid) {
        this.view_uuid = view_uuid;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
    @Override
    public String toString(){
        return "view_uuid: "+view_uuid+"votes: "+votes;
    }
}
