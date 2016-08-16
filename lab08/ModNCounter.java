public class ModNCounter {

	private int myCount;
	private int upper = 3;

	public ModNCounter() {
		myCount = 0;
	}

	public void increment() {
		if(myCount + 1 == upper)
			myCount = 0;
		else
			myCount++;
	}

	public void reset() {
		myCount = 0;
	}

	public int value() {
		return myCount;
	}

}
