import java.util.Scanner;
public class fracCalc {

	public static void main(String[] args) {
		System.out.println("This program is a fraction calculator. It will add, subtract, multiply, and divide fractions, until you type Q to quit. Please enter your fraction in the form a or b where a and b are integers and b is not equal to 0.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a valid mathematical operation(+, -, /, *, =, or Q to quit)");
		String go = getOperation(scan);

		if(go.equalsIgnoreCase("Q"))
		{
			System.out.println("The program has terminated");
			System.exit(0);
		}
		
		fraction fir = getFraction(scan);
		fraction sec = getFraction(scan);
		fraction fin = new fraction();
	/*	if(go.equalsIgnoreCase("Q"))
		{
			System.out.println("The program has terminated");
			System.exit(0);
		}*/
		if(go.equals("*"))
		{
			fin = fir.multiply(sec);
		}
		else if(go.equals("/"))
		{
			fin = fir.divide(sec);
		}
		else if(go.equals("+"))
		{
			fin = fir.add(sec);
		}
		else if(go.equals("-"))
		{
			fin = fir.subtract(sec);
		}
		fin.toLowestTerms();
		System.out.println(fir.toString() + " " + go + " " + sec.toString() + " = " + fin.toString());
		System.out.println("_________________________________________________________________");			
		
	
		
		//FIX GETOPERATION
	}
		
	public static String getOperation(Scanner scan)
	{
		String op = scan.next();
		if((op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*") || op.equals("=") || op.equalsIgnoreCase("Q")))
		{
			return op;
		}
		else { 	
			System.out.println("Invalid operation(+, -, /, *, =, or Q to quit)");
			return getOperation(scan);
		}
		
	}
	public static boolean validFraction(String a)
	{
		int divInd = a.indexOf("/");
		if(divInd!= -1)
		{
		//	boolean isONeg = false;
			String pone = a.substring(0,divInd);
			String ptwo = a.substring(divInd+1);
			if(pone.substring(0, 1).equals("-"))
			{
				pone = pone.substring(1);
				//isONeg = true;
				if(pone.indexOf("-") != -1 || ptwo.indexOf("-") != -1)
				{
					//System.out.println("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero.");
					return false;
				}
				if(isNumeric(pone) && isNumeric(ptwo))
				{
					return true;
				}
			}
			
		}
		else {
			if(isNumeric(a))
			{
				return true;
			}
			else {return false;}
		}
		
		return true;
	}
	public static boolean isNumeric(String str) { 
		try{  
			Integer.parseInt(str);  
			return true;
		}
	
		catch(NumberFormatException e)
		{  
		    return false;  
		}  
	}
	
	public static fraction getFraction(Scanner scan)
	{
		System.out.println("Please enter a fraction (a/b) or integer (a): ");
		String sscan = scan.next();
		if(!validFraction(sscan))
		{
			System.out.println("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero.");
			getFraction(scan);
		}
		else {
			int divInd = sscan.indexOf("/");
			if(divInd != -1)
			{
				String a = sscan.substring(0, divInd);
				String b = sscan.substring(divInd+1);
				fraction ret = new fraction(Integer.parseInt(a),Integer.parseInt(b));
				return ret;
			} 
			else {
				String a = sscan;
				fraction ret = new fraction(Integer.parseInt(a));
				return ret;
			}
			 
			
		}
		fraction frac = new fraction();
		return frac;
		
	}
}
