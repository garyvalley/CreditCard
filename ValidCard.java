/** 
 * ValidCard.java
 *
 * 12 July 2016
 *
 * Verify that a credit card is valid
 */

// imports
import java.util.Scanner;


// a class for verifying a credit card #
public class ValidCard {
	// empty constructor
	public ValidCard() {} 

	/**
	 * validNumber
	 * 	Determine if a number is a valid credit card #
	 * ---------------------------------------------------
	 *  	@param number: A string indicating the credit card # to verify (no spaces)
	 * ---------------------------------------------------
	 *  	Returns a boolean indicating valid or invalid
	 */
	public boolean validNumber( String number ) {
		// a valid ccard has 16 digits
		if( number.length() == 16 ) {
			int sum       = 0;
			int nextDigit = 0;
			int nextNum   = 0;

			// sum up twice the odd digits (keeping only the lowest order value) and the even digits 
			// if the sum is a multiple of 10, it's valid.
			// if not, it's invalid
			for( int i = 0; i < number.length(); i++ ) {
				nextDigit = Integer.parseInt( String.valueOf( number.charAt( i )));

				if( i % 2 == 0 ) {
					nextDigit = ( nextDigit > 4 ) ? ( nextDigit * 2 - 10 ) + 1 : nextDigit * 2;
				} // end if/else

				sum += nextDigit;
			} // end for

			if( sum % 10 == 0 ) {
				return true;
			} else {
				return false;
			} // end if/else
		} else {
			return false;
		} // end if/else
	} // end validNumber


	/**
	 * main
	 * 	The entry point for this application
	 */
	public static void main( String[] args ) {
		Scanner   scanner = new Scanner( System.in );
		long      number  = scanner.nextLong();
		ValidCard vc      = new ValidCard();

		if( vc.validNumber( String.valueOf( number ).replaceAll( " ", "" ))) {
			System.out.println( "Valid card #: " + number );
		} else {
			System.out.println( "Invalid card #: " + number );
		} // end if/else
	} // end main
} // end class ValidCard
