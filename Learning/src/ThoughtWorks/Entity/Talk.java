package ThoughtWorks.Entity;

import ThoughtWorks.util.UtilService;

import java.util.Date;

/**
 * Created by shubhamsharma on 12/14/2015.
 */
public class Talk {

    private Date startTime;
    private Date endTime;
    private Session sessionType;
    String name;
    int length;
    public Talk()
    {

    }
    public Talk(Date startTime, Date endTime, Session sessionType, String name,int length) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionType = sessionType;
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Session getSessionType() {
        return sessionType;
    }

    public void setSessionType(Session sessionType) {
        this.sessionType = sessionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDateFormat() {
        return UtilService.getDateFormatter().format(this.getStartTime());
    }

    public String getEndDateFormat() {
        return UtilService.getDateFormatter().format(this.getEndTime());
    }

}
