
public class MemoryHogger {

	public static void main(String[] args) {

		doSomething(2);
	}

	public static void doSomething(int arg) {
		while (10 == 10) {
			arg++;
			doSomething(arg); // will fill up the stack memory due to indefinite recursive calls. Willcause
								// stack overflow error.
		}

	}
}