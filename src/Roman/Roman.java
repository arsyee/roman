package Roman;

public class Roman {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	public static class Exception extends Throwable {
		private static final long serialVersionUID = 1L;

		Exception (String s) {
			super(s);
		}
	}

	public static String intToRoman(int number) throws Exception {
		if (number<0) throw new Exception("Negative number");
		StringBuilder roman = new StringBuilder();

		String[] Is = {"I", "X", "C", "M", ""};
		String[] Vs = {"V", "L", "D", "", ""};
	    for (int i = 0; i < 4; ++i) {
	    	int digit = number%10;
		    roman.insert(0, convertDigit(digit, Is[i], Vs[i], Is[i+1]));
		    number /= 10;
	    }
	    
	    return roman.toString();
	}
	
	private static String convertDigit(int digit, String I, String V, String X) {
		switch (digit) {
		  case 1 : return I;
		  case 2 : return I+I;
		  case 3 : return I+I+I;
		  case 4 : return I+V;
		  case 5 : return V;
		  case 6 : return V+I;
		  case 7 : return V+I+I;
		  case 8 : return V+I+I+I;
		  case 9 : return I+X;
		  default : return "";
		}
	}
	
	public static int romanToInt(String r) throws Exception {
		int number = 0;
		int nr =0;
		int lastNr =0;
		System.out.println(r+" length: "+r.length());
		for (int i=0;i<r.length();i++) {
		  switch (r.charAt(i)) {
		    case 'I' : nr = 1; break;
		    case 'V' : nr = 5; break;
		    case 'X' : nr = 10; break;
		    case 'L' : nr = 50; break;
		    case 'C' : nr = 100; break;
		    case 'D' : nr = 500; break;
		    case 'M' : nr = 1000; break;
		    
		    default : throw new Exception("Unknown character: "+r.charAt(i));
		  }
		  
		  if (lastNr<nr) {
			number += -2*lastNr;
		  }
		  lastNr = nr;
		  number += nr;
		}
		System.out.println(number);
		return number;
	}
}
