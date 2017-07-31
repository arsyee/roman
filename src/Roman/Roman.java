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
		if (number>=4000) throw new Exception("Higher than maximum value");
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
		int solution = 0;
		int current = 0;
		int previous = 0;		
		int counter = 1;
		
		for (int i=0; i<r.length(); i++) {
		  switch (r.charAt(i)) {
		    case 'I' : current = 1; break;
		    case 'V' : current = 5; break;
		    case 'X' : current = 10; break;
		    case 'L' : current = 50; break;
		    case 'C' : current = 100; break;
		    case 'D' : current = 500; break;
		    case 'M' : current = 1000; break;
		    
		    default : throw new Exception("Unknown character: "+r.charAt(i));
		  }
		  
		  if (previous<current) {
			solution += -2*previous;
			if (counter>1) {
				throw new Exception("Wrong number");
			}
		  }
		  		  
		  if (previous == current) {
			  counter++;
			  if (current == 5 || current == 50 || current == 500) {
				  throw new Exception("Too many same characters");
			  } 
		  } else {
			  counter = 1;
		  }
		  if (counter > 3) {
			  throw new Exception("Too many same characters");
		  }
		  previous = current;
		  solution += current;
		}

		return solution;
	}
}
