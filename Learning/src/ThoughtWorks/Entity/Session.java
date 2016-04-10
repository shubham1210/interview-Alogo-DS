package ThoughtWorks.Entity;

import java.util.List;

/**
 * Created by shubhamsharma on 12/14/2015.
 */
public class Session {
    private String name;
    private List<Talk> talks;
    private int length;

    public Session(String name, List<Talk> talks, int length) {
        this.name = name;
        this.talks = talks;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
