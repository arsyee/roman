package Roman;

public class Roman {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static String intToRoman(int i) {
		switch (i) {
		  case 1 : return "I";
		  case 5 : return "V";
		  case 10 : return "X";
		  case 50 : return "L";
		  case 100 : return "C";
		  case 500 : return "D";
		  case 1000 : return "M";
		}
	    return "I";
	}
	
	public static int romanToInt(String r) {
		return 0;
	}
}
