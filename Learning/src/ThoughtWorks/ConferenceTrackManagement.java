package ThoughtWorks;

import ThoughtWorks.Entity.Talk;
import ThoughtWorks.util.Constants;
import ThoughtWorks.util.UtilService;
import ThoughtWorks.util.exception.InvalidInputException;

import java.util.List;

/**
 * This is the main Executable class where the process begins
 * Created by shubhamsharma on 12/14/2015.
 */
public class ConferenceTrackManagement {

    public static void main(String[] a)
    {
        List<Talk> parseFile= UtilService.parseFile(Constants.inputFilePath);
        try{
            UtilService.calculateCombination(parseFile);
        }
        catch (InvalidInputException e)
        {
            e.printStackTrace();
        }
    }
}
