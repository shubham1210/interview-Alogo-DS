package ThoughtWorks.Entity;

import java.util.Date;

/**
 * Created by shubhamsharma on 12/14/2015.
 */
public class Track {
    private Session eveningSession;
    private Session morningSession;
    private Date day;

    public Track(Session eveningSession, Session morningSession, Date day) {
        this.eveningSession = eveningSession;
        this.morningSession = morningSession;
        this.day = day;
    }

    public Session getEveningSession() {
        return eveningSession;
    }

    public void setEveningSession(Session eveningSession) {
        this.eveningSession = eveningSession;
    }

    public Session getMorningSession() {
        return morningSession;
    }

    public void setMorningSession(Session morningSession) {
        this.morningSession = morningSession;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
