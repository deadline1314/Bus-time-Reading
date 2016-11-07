package FinalQuestion;

public class CountHi {

	int countHi(String str) {
		if (str.length() < 2) {
			return 0;
		}
		if (str.length() >= 3 && str.substring(0, 3).equals("xhi")) {
			return countHi(str.substring(3, str.length()));
		}
		if (str.length() >= 2 && str.substring(0, 2).equals("hi")) {
			return 1 + countHi(str.substring(2, str.length()));
		} else
			return countHi(str.substring(1));

	}

	public static void main(String[] args) {
		CountHi ch = new CountHi();
		System.out.println(ch.countHi("ahixhi")); // count = 1
		System.out.println(ch.countHi("xhixhi")); // count = 0
		System.out.println(ch.countHi("ahibhi")); // count = 2

	}

}
