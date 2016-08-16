public class SieveOfEratosthenes {

	public static void main(String[] args) {
		if (args.length < 1) { 
			System.out.println("You need to enter an argument!");
			return;
		}
		int upperBound = Integer.parseInt(args[0]);
		boolean[] isNotPrime = new boolean[upperBound];
		for (int i = 2; i*i < upperBound; i++) {
			if (isNotPrime[i] == true) {
				continue;
			} else {
				//THIS DATA HAS BEEN CORRUPTED; REPLACE IT!
				int p = i;
				while(p*i<upperBound){
					isNotPrime[p*i] = true;
					p++;
				}
			}
		}
		for (int i = 2; i < upperBound; i++) {
			if (!isNotPrime[i]) {
				System.out.println(i + " is a prime number.");
			}
		}
	}
}
