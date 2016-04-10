package Expedia;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shubhamsharma on 12/1/2015.
 */
public class sortArrayOnLenght {

    String[] input = {"cat", "star", "act", "gid", "arts", "dog", "rats"};
    //Collections.sort(input,new SampleComparator());
}
class SampleComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return new Integer(o1.length()).compareTo(o2.length());
    }
}