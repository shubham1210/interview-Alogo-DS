package ThoughtWorks.util.Enums;

/**
 * This class is used to define number of possible types for any category in the system
 * Created by shubhamsharma on 12/14/2015.
 */
public class Type {

    /**
     * This is session type that defines maximum number of session in the system
     */
    public static enum SessionType
    {
        MORNING("Morning"),EVENING("Evening"),LUNCH("Lunch"),NETWORK("Networking Event");

        private String val;

        SessionType(String val) {
            this.val = val;
        }
        public String value() {
            return val;
        }
    }
}
