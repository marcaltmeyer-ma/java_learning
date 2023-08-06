package CheckPackage;

public class Checker {

	public static boolean checker(char check, char[] toCheck) {
		// TODO Auto-generated method stub
		for (int i = 0; i < toCheck.length; i++) {
			if (check == toCheck[i]) {
				return true;
			}
			//return false;
		}
		return false;
	}

}
