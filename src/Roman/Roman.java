package Roman;

import java.util.HashMap;
import java.util.Iterator;

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
	
	public static final int MAX = 3999;

	private static class TwoWayHashMap<K, T> extends HashMap<K, T> {
		private static final long serialVersionUID = 1L;
		K getByValue(T t) {
			Iterator<Entry<K, T>> it = this.entrySet().iterator();
		    while (it.hasNext()) {
		        Entry<K, T> pair = it.next();
		        if (pair.getValue().equals(t)) return (K) pair.getKey();
		    }
			return null;
	    }
	}
	
	private static TwoWayHashMap<Character, Integer> Iss = new TwoWayHashMap<Character, Integer>();
	static {
		Iss.put('I', 1);
		Iss.put('X', 10);
		Iss.put('C', 100);
		Iss.put('M', 1000);
	}
	private static TwoWayHashMap<Character, Integer> Vss = new TwoWayHashMap<Character, Integer>();
	static {
		Vss.put('V', 5);
		Vss.put('L', 50);
		Vss.put('D', 500);
	}
	
	public static String intToRoman(int number) throws Exception {
		if (number<0) throw new Exception("Negative number: "+number);
		if (number>MAX) throw new Exception("Higher than maximum ("+MAX+") value: "+number);
		StringBuilder roman = new StringBuilder();
		
		int multiplier = 1;

	    for (int i = 0; number > 0 && i < 4; ++i) {
	    	int digit = number%10;
		    roman.insert(0, convertDigit(digit, Iss.getByValue(multiplier), Vss.getByValue(multiplier*5), Iss.getByValue(multiplier*10)));
		    number /= 10;
		    multiplier *= 10;
	    }
	    
	    return roman.toString();
	}
	
	private static String convertDigit(int digit, Character I, Character V, Character X) throws Exception {
		switch (digit) {
		  case 0 : return ""; 
		  case 1 : return ""+I;
		  case 2 : return ""+I+I;
		  case 3 : return ""+I+I+I;
		  case 4 : return ""+I+V;
		  case 5 : return ""+V;
		  case 6 : return ""+V+I;
		  case 7 : return ""+V+I+I;
		  case 8 : return ""+V+I+I+I;
		  case 9 : return ""+I+X;
		  default : throw new Exception("Unknown digit: "+digit);
		}
	}
	
	public static int romanToInt(String input) throws Exception {
		int solution = 0;
		int current = 0;
		int previous = 0;		
		int counter = 1;
		
		for (int i=0; i<input.length(); i++) {
		  current = getValue(input.charAt(i));
		  
		  if (previous>0 && previous<current) {
			if (counter>1) {
				throw new Exception("Cannot substract multiple times: "+previous);
			}
			if (Iss.values().contains(previous) && (current == 10*previous || current == 5*previous)) {
				solution += -2*previous;
			} else {
				throw new Exception("Cannot substract "+previous+" from "+current);
			}
		  }

		  if (previous == current) {
			  ++counter;
			  if (counter > 3 || Vss.containsValue(current)) {
				  throw new Exception("Too many characters: "+input.charAt(i));
			  } 
		  } else {
			  counter = 1;
		  }		  
		  
		  previous = current;
		  solution += current;
		}

		return solution;
	}

	private static int getValue(char c) throws Exception {
		if (Iss.containsKey(c)) return Iss.get(c);
		if (Vss.containsKey(c)) return Vss.get(c);
		throw new Exception("Unknown character: "+c);
	}
}
