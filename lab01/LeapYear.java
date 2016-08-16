/** Class that determines whether or not a year is a leap year.
 *  @author Jingbin Yang
 */
import java.util.Scanner;
public class LeapYear{
	/** @param  year to be analyzed
     *  @return true if year is a leap year
     *          false if year is not a leap year
     */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);//Instance of a input class
		System.out.println("Please input a year:");
		int year = in.nextInt();//To get the next integer as year
		if(year%400==0||(year%4==0&&year%100!=0))
			System.out.println("It's a leapyear!");
		else System.out.println("It's not a leapyear!");
	}
}