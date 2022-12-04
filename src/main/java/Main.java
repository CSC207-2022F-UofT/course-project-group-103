import screens.*;

public class Main {
    /**
     * Filepaths for the database can be changed in the GUI class,
     * run main to start. Sign up isn't implemented right now but
     * accounts that are in the user listing json work.
     */
    public static void main(String[] args) {
        GUI application = new GUI();
        application.pack();
        application.setVisible(true);
    }
}
