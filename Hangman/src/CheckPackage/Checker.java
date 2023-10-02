package CheckPackage;

public class Checker {

	public static boolean check(char checkChar, char[] toCheck) {
		for (int i = 0; i < toCheck.length; i++) {
			if (checkChar == toCheck[i]) {
				return true;
			}
		}
		return false;
	}

}
