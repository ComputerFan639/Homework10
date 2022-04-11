/* This file contains a subclass of the abstract superclass Loan that represents information about a personal loan.
 * Assignment: 10
 * Name: Katherine Nelson
 * Date: 4/11/2022
 * Professor: Sheikh Shamsuddin
 * Class Code: CPSC-24500-002
 * File Name: PersonalLoan.java
 */

package homework10;

public class PersonalLoan extends Loan {

	public PersonalLoan() {
		super();
	}

	public PersonalLoan(String loanNumber, String customerLastName, double loanAmount, String term, double currentPrimeInterestRate) {
		super(loanNumber, customerLastName, loanAmount, term);
		
		interestRate = currentPrimeInterestRate + 2;
	}
	
	@Override
	public String toString() {
		return "Company Name: " + companyName + "\n"
				+ "Loan Type: Personal Loan" + "\n"
				+ "Loan Number: " + loanNumber + "\n"
				+ "Customer Last Name: " + customerLastName + "\n"
				+ "Loan Amount: " + "$" + String.format("%.2f", loanAmount) + "\n"
				+ "Interest Rate: " + interestRate + "%" + "\n"
				+ "Term: " + term;
	}
}
