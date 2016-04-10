package inheritance;

/**
 * Created by shubhamsharma on 4/7/2015.
 */
public class Vichle {

    private int call(int a)
    {
        return a;
    }

    private int call(String b)
    {
        return -1;
    }
}

class car extends Vichle{

    public car(int a) {
    
    }

    public int call(int a)throws RuntimeException
    {
        return -1;
    }

}