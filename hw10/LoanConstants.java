/* This file contains an interface that has multiple constant values, which allows classes implementing this interface to use these constant values as needed
 * (used in the process of creating loans).
 * Assignment: 10
 * Name: Katherine Nelson
 * Date: 3/27/2022
 * Professor: Sheikh Shamsuddin
 * Class Code: CPSC-24500-002
 * File Name: LoanConstants.java
 */

package homework10;

public interface LoanConstants {
	String shortTerm = "1 year";
	String mediumTerm = "3 years";
	String longTerm = "5 years";
	String companyName = "HighTech Construction Loan Company";
	double maximumLoanAmount = 500000;
}
