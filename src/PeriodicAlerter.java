import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PeriodicAlerter {
	int delay_minutes;
	int break_count;
	int desired_breaks;

	/**
	 * Instates a new PeriodicAlerter with the desired delay time
	 * 
	 * @param minutes The time between each notification
	 * @throws InterruptedException
	 */
	public PeriodicAlerter(int minutes) throws InterruptedException {
		this.delay_minutes = minutes;
		this.break_count = 0;
		this.desired_breaks = (9 * 60) / minutes;
		
		Notify();
	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 */
	private void Notify() throws InterruptedException {
		final int sleep_milliseconds = delay_minutes * 60 * 1000;
		JOptionPane pane = new JOptionPane();
		pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

		// this was added because the dialog box was being
		// created too small and not all message text was
		// appearing.
		pane.setMessage(getMessage());

		JDialog dialog = pane.createDialog("Health Reminder");
		dialog.setAlwaysOnTop(true);

		while (true) {
			Thread.sleep(sleep_milliseconds);
			java.awt.Toolkit.getDefaultToolkit().beep();
			pane.setMessage(getMessage());
			dialog.setVisible(true);
			break_count++;
		}
	}

	/**
	 * 
	 * @return
	 */
	private String getMessage() {
		return "It has been " + Integer.toString(delay_minutes)
				+ " minutes since your last break.\n"
				+ "Please take 20 seconds to walk away from your desk.\n"
				+ "Breaks taken today: " + Integer.toString(break_count) + "/"
				+ Integer.toString(desired_breaks);
	}
}
