import java.util.*;
public class Team {
    public static List<Team> teams=new ArrayList<Team>();

    private String name;

    public Team(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
