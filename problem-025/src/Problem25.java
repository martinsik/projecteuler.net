import com.martinsikora.BigInteger;


public class Problem25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String prev = "1", pprev = "1", current;
		long counter = 3;
		
		current = BigInteger.sum(prev, pprev);
		while (current.length() < 1000) {
			counter++;
			pprev = prev;
			prev = current;
			current = BigInteger.sum(prev, pprev);
		}
		System.out.println("Cycle: " + BigInteger.cycles);
		System.out.println("Term: " + counter);
	}

}
