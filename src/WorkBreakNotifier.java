/**
 * 
 * @author jasonklein
 *
 */
public class WorkBreakNotifier {
	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		if (args.length == 1) {
			System.out.println("WorkBreakNotifier is running...");
			new PeriodicAlerter(Integer.parseInt(args[0]));
		} else {
			System.out.println("Usage: java WorkBreakNotifier [time_in_minutes]");
		}
	}
}
