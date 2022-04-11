/* This file contains a subclass of the abstract superclass Loan that represents information about a business loan.
 * Assignment: 10
 * Name: Katherine Nelson
 * Date: 4/11/2022
 * Professor: Sheikh Shamsuddin
 * Class Code: CPSC-24500-002
 * File Name: BusinessLoan.java
 */

package homework10;

public class BusinessLoan extends Loan {

	public BusinessLoan() {
		super();
	}

	public BusinessLoan(String loanNumber, String customerLastName, double loanAmount, String term, double currentPrimeInterestRate) {
		super(loanNumber, customerLastName, loanAmount, term);
		
		interestRate = currentPrimeInterestRate + 1;
	}
	
	@Override
	public String toString() {
		return "Company Name: " + companyName + "\n"
				+ "Loan Type: Business Loan" + "\n"
				+ "Loan Number: " + loanNumber + "\n"
				+ "Customer Last Name: " + customerLastName + "\n"
				+ "Loan Amount: " + "$" + String.format("%.2f", loanAmount) + "\n"
				+ "Interest Rate: " + interestRate + "%" + "\n"
				+ "Term: " + term;
	}
	
}
