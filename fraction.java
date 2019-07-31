
public class fraction {
	private int num;
	private int den; 
	
	public fraction(int n, int d)
	{
		if(d<0)
		{
			d = -d;
			n = -n;
		}
		this.num = n;
		if(d != 0)
		{	
			this.den = d;
		}
		else {throw new IllegalArgumentException();}		
 
	}
	
	public fraction(int n)
	{
		this(n,1);
	}
	
	public fraction()
	{
		this(0,1);
	}
	
	public int getNumerator()
	{
		return num;
	}
	
	public int getDenominator()
	{
		return den;
	}
	
	public String toString()
	{
		return Integer.toString(num) + "/" + Integer.toString(den);
	}
	
	public double toDouble()
	{
		return (double) num/den;
	}
	
	public fraction add(fraction a)
	{
		int n = a.getNumerator();
		int d = a.getDenominator();
		
		fraction ret = new fraction(n*den + d*num, d*den);
		return ret;
	}
	public fraction subtract(fraction a)
	{
		int n = a.getNumerator();
		int d = a.getDenominator();
		
		fraction ret = new fraction(d*num- n*den, d*den);
		return ret;
	}
	public fraction multiply(fraction a)
	{
		int n = a.getNumerator();
		int d = a.getDenominator();
		
		fraction ret = new fraction(num*n, d*den);
		return ret;
	}
	public fraction divide(fraction a)
	{
		int n = a.getNumerator();
		int d = a.getDenominator();
		
		if(n != 0)
		{
			fraction ret = new fraction(num*d, den*n);
			return ret;
		}
		else {throw new IllegalArgumentException();}
	}
	public boolean equals(Object a)
	{
		if(a == this) return true;
		
		if(!(a instanceof fraction)) return false; 
		
		fraction aFrac = (fraction) a;
		return num==aFrac.getNumerator() && den == aFrac.getDenominator();
	}
	public void toLowestTerms()
	{
		int gc = gcd(num, den);
		num = num/gc;
		den = den/gc;
	}
	public static int gcd(int n, int d)
	{
		int rem;
		while(n!= 0 && d!= 0)
		{
			rem = n%d;
			n = d;
			d = rem;
		}
		return n;
	}
}
