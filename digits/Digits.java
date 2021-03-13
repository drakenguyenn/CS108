/**
 *  Program 1b
 *  Digits examines an integer and can return the first and last digit as well as the number of digits based on the method. 
 *  CS108-3
 *  September 4,2018
 *  Drake Nguyen
  */
public class Digits {
	/**
	 * 
	 * @param integer n
	 * @return the first digit in int n
	 */
	public int firstDigit(int n)
	{
		//Math.abs so negative numbers won't return -n
		//while n has more than two digits, divide until only the first remains
		n = Math.abs(n);
        while(n>=10) 
        {
        	n /= 10;
        }
        return n;
	}
	/**
	 * 
	 * @param integer n
	 * @return the last digit in int n
	 */
	public int lastDigit(int n)
	{
		//Math.abs so negative numbers won't return -n
		return Math.abs(n%10);
	}
	/**
	 * 
	 * @param integer n
	 * @return the number of digits in int n
	 */
	public int digits(int n) 
	{
		//Math.abs so negative sign will not count towards digits
		//Change n into a string to use length() method
		return String.valueOf(Math.abs(n)).length();
	}

}


