
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
 * seconds have passed.
 */
public class CheckLoanDue {

    Toolkit toolkit;

    Timer timer;

    public CheckLoanDue(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
    }

    class RemindTask extends TimerTask {

        public void run() {
            //update on the loans due date

        }
    }

    public static void main(String args[]) {
        System.out.println("About to update on the loan due date");
        new CheckLoanDue(5);
        System.out.println("Loan updated");
    }
}
