package ThoughtWorks.util;

import ThoughtWorks.Entity.Session;
import ThoughtWorks.Entity.Talk;
import ThoughtWorks.Entity.Track;
import ThoughtWorks.util.Enums.Type;
import ThoughtWorks.util.exception.InvalidInputException;
import ThoughtWorks.util.exception.InvalidTalkException;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class is used for Utility
 * Created by shubhamsharma on 12/14/2015.
 */
public class UtilService {

    private static DateFormat dateFormatWithTime;

    /**
     * This method returns dateFormatter as DateFormat is a Expensive Object
     * @return DateFormat
     */
    public static DateFormat getDateFormatter()
    {
        if(dateFormatWithTime == null)
            dateFormatWithTime = new SimpleDateFormat("HH:mma");
        return  dateFormatWithTime;
    }

    /**
     * This method find out the number of talks and bind them in to proper structure
     * @param input list of Talks after parsing from File Input
     * @throws InvalidInputException
     */
    public static void calculateCombination(List<Talk> input) throws InvalidInputException{

        if(input == null || input.size() == 0)
        {
            throw new InvalidInputException("Input is not valid");
        }
        Calendar cal = Calendar.getInstance();

        //helping variables to maintain total time for morning and evening
        int morningTemp = 0, eveningTemp = 0;

        //number of session possible per conference
        //passing second params is null because at the time of creation no talks is associated with sessions
        Session morningSession = new Session(Type.SessionType.MORNING.value(), null, calculateSessionDuration(Type.SessionType.MORNING));
        Session eveningSession = new Session(Type.SessionType.EVENING.value(), null, calculateSessionDuration(Type.SessionType.EVENING));
        Session lunchSession = new Session(Type.SessionType.LUNCH.value(), null, calculateSessionDuration(Type.SessionType.LUNCH));
        Session networkSession = new Session(Type.SessionType.NETWORK.value(), null, calculateSessionDuration(Type.SessionType.NETWORK));

        //List of morning and evening talks in a day
        List<Talk> morningTalks = new ArrayList<Talk>();
        List<Talk> eveningTalks = new ArrayList<Talk>();

        //This is finally a number of Tracks in whole conference
        List<Track> tracks = new ArrayList<Track>();

        boolean resetDataFlag = true;

        initializeCalender(cal, Constants.startTimeMorningSession, 0, 0);

        for (int i = 0; i < input.size(); i++) {
            if (morningTemp + input.get(i).getLength() <= morningSession.getLength()) {
                addTalkToSession(cal, input.get(i), morningSession, morningTalks);
                morningTemp += input.get(i).getLength();

            } else if (eveningTemp + input.get(i).getLength() <= eveningSession.getLength()) {
                if (resetDataFlag) {
                    initializeCalender(cal, Constants.lunchStartTime, 0, 0);
                    addTalkToSession(cal, new Talk(null,null,lunchSession,Type.SessionType.LUNCH.value(),lunchSession.getLength()), lunchSession, morningTalks);
                    morningSession.setTalks(morningTalks);
                    resetDataFlag = false;
                    initializeCalender(cal, Constants.startTimeEveningSession, 0, 0);
                }
                addTalkToSession(cal, input.get(i), eveningSession, eveningTalks);
                eveningTemp += input.get(i).getLength();
            } else {
                //adding network event and evening
                addNetworkTask(cal, eveningTalks, networkSession);
                eveningSession.setTalks(eveningTalks);
                tracks.add(new Track(eveningSession, morningSession, cal.getTime()));

                //reset data and calendar for next day
                initializeCalender(cal, Constants.startTimeMorningSession, 0, 0);
                cal.add(Calendar.DAY_OF_MONTH, 1);
                resetDataFlag = true;
                morningSession = new Session(Type.SessionType.MORNING.value(), null, calculateSessionDuration(Type.SessionType.MORNING));
                eveningSession = new Session(Type.SessionType.EVENING.value(), null, calculateSessionDuration(Type.SessionType.EVENING));
                eveningTalks = new ArrayList<Talk>();
                morningTalks = new ArrayList<Talk>();
                morningTemp = 0;
                eveningTemp = 0;
            }
        }
        //adding for loop breaking condition
        addNetworkTask(cal, eveningTalks, networkSession);
        eveningSession.setTalks(eveningTalks);
        tracks.add(new Track(eveningSession, morningSession, cal.getTime()));
        printData(tracks);
    }


    /**
     * Print the conference data per Track
     * @param tracks
     */
    private static void printData(List<Track> tracks) throws InvalidInputException{

        if(tracks == null || tracks.size() == 0)
        {
            throw new InvalidInputException("Input is not valid");
        }
        for (int i=0;i<tracks.size();i++)
        {
            System.out.println("Track: "+i+1);
            printDataPerSession(tracks.get(i).getMorningSession());
            printDataPerSession(tracks.get(i).getEveningSession());
        }
    }

    /**
     * Print all talks under passing session
     * @param session
     */
    private static void printDataPerSession(Session session)
    {
        if(session == null)  return;
        Talk tempTalk;
        for (int i = 0; i < session.getTalks().size(); i++) {
            tempTalk = session.getTalks().get(i);
            System.out.println(tempTalk.getStartDateFormat()+ " " +tempTalk.getName() +" "+tempTalk.getLength() +Constants.minSuffix);
        }
    }

    /**
     * reset Calendar with specific passing params
     * @param cal Calendar instance
     * @param hod Hour of day
     * @param min Minutes
     * @param sec Second
     */
    private static void initializeCalender(Calendar cal, int hod, int min, int sec) {
        if(cal == null)return;
        cal.set(Calendar.HOUR_OF_DAY, hod);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, sec);
    }

    /**
     * reset Calendar with specific passing Date
     * @param cal
     * @param date
     */
    private static void initializeCalenderByDate(Calendar cal, Date date) {
        if(cal == null)return;
        cal.setTime(date);
    }

    /**
     * Adding talk passing talk list
     * @param cal Calendar object
     * @param currentTalk Talk
     * @param session session for which task is associated
     * @param talks
     */
    private static void addTalkToSession(Calendar cal, Talk currentTalk, Session session, List<Talk> talks) {
        if(cal == null || currentTalk == null || session==null || talks == null)return;
        currentTalk.setStartTime(cal.getTime());
        cal.add(Calendar.MINUTE, currentTalk.getLength());
        currentTalk.setEndTime(cal.getTime());
        currentTalk.setSessionType(session);
        talks.add(currentTalk);
    }

    /**
     * Adding specific network talk to list
     * @param cal
     * @param eveningTalks
     * @param networkSession
     */
    private static void addNetworkTask(Calendar cal, List<Talk> eveningTalks, Session networkSession) {
        if(cal == null || eveningTalks == null || networkSession==null)return;
        //fetching last event from the list
        Talk tempTalk = eveningTalks.get(eveningTalks.size() - 1);

        cal.setTime(tempTalk.getStartTime());
        //if last session is before 4 then no network session will be start around 4
        if (cal.get(Calendar.HOUR_OF_DAY) < Constants.startTimeNetworkSession - 1) {
            initializeCalender(cal, 16, 0, 0);
            addTalkToSession(cal,new Talk(null,null,networkSession,Type.SessionType.NETWORK.value(),networkSession.getLength()) , networkSession, eveningTalks);
        }
        // if last session is after 4 then network session will be start around end time of last session
        else if (cal.get(Calendar.HOUR_OF_DAY) == 16 && cal.get(Calendar.MINUTE) < 60) {
            initializeCalenderByDate(cal,tempTalk.getEndTime());
            tempTalk = new Talk();
            tempTalk.setLength(networkSession.getLength());
            tempTalk.setName(Type.SessionType.NETWORK.value());
            addTalkToSession(cal, tempTalk, networkSession,eveningTalks);
        }
    }

    /**
     * This method parse the input file and throw a exception when any wrong data found
     * @param path
     * @return return list of talks
     */
    public static List<Talk>  parseFile(String path)
    {
        List<String> talkList = new ArrayList<String>();
        List<Talk> talks = new ArrayList<Talk>();
        try{
            // Open the file.
            FileInputStream fis = new FileInputStream(path);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();
            //Read File Line By Line
            while (strLine != null)   {
                talkList.add(strLine);
                strLine = br.readLine();
            }
            //Close the input stream
            in.close();
            talks = validateAndCreateTalks(talkList);
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            talks =null;
        }
        return talks;
    }

    /**
     * This method validate List of String Talks and create Talk object
     * @param talkList
     * @return
     * @throws InvalidTalkException
     */
    public static List<Talk> validateAndCreateTalks(List<String> talkList) throws InvalidTalkException
    {
        if(talkList == null)
            throw new InvalidTalkException("Empty Talk List");

        List<Talk> validTalksList = new ArrayList<Talk>();
        // Iterate list and validate time.
        for(String talk : talkList)
        {
            checkString(talk,validTalksList);
        }

        return validTalksList;
    }

    /**
     * This method checks the input string whether it is valid or not
     * @param talk
     * @param validTalksList
     * @throws InvalidTalkException
     */
    private static void checkString(String talk,List<Talk> validTalksList) throws InvalidTalkException
    {
        String name =null,timeStr=null;
        int lastSpaceIndex = talk.lastIndexOf(" ");
        // if talk does not have any space, means either title or time is missing.
        if(lastSpaceIndex == -1)
            throw new InvalidTalkException("Invalid talk, " + talk + ". Talk time must be specify.");

        name = talk.substring(0, lastSpaceIndex);
        timeStr = talk.substring(lastSpaceIndex + 1);
        // If title is missing or blank.
        if(name == null || "".equals(name.trim()))
            throw new InvalidTalkException("Invalid talk name, " + talk);
            // If time is not ended with min or lightning.
        else if(timeStr.endsWith(Constants.minSuffix) ==false && timeStr.endsWith(Constants.lightningSuffix) ==false)
            throw new InvalidTalkException("Invalid talk time, " + talk + ". Time must be in min or in lightning");

        int time = 0;

        try{
            if(timeStr.endsWith(Constants.minSuffix)) {
                time = Integer.parseInt(timeStr.substring(0, timeStr.indexOf(Constants.minSuffix)));
            }
            else if(timeStr.endsWith(Constants.lightningSuffix)) {
                String lightningTime = timeStr.substring(0, timeStr.indexOf(Constants.lightningSuffix));
                if("".equals(lightningTime))
                    time = 5;
                else
                    time = Integer.parseInt(lightningTime) * 5;
            }
        }catch(NumberFormatException nfe) {
            throw new InvalidTalkException("Unable to parse time " + timeStr + " for talk " + talk);
        }

        validTalksList.add(new Talk(null,null,null,name,time));
    }

    /**
     * This calculates the duration in minutes for any specific session
     * @param type
     * @return
     */
    public static int calculateSessionDuration(Type.SessionType type)
    {
        if(type == Type.SessionType.MORNING)
        {
            return (Constants.endTimeMorningSession-Constants.startTimeMorningSession)*60 ;
        }
        else if(type == Type.SessionType.EVENING) {

            return (Constants.endTimeEveningSession-Constants.startTimeEveningSession)*60;
        }
        else if(type == Type.SessionType.NETWORK) {

            return (Constants.endTimeNetworkSession-Constants.startTimeNetworkSession)*60;
        }
        else if(type == Type.SessionType.LUNCH) {

            return (Constants.lunchEndTime-Constants.lunchStartTime)*60;
        }
        return -1;
    }
}
