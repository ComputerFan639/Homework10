/* This file contains an abstract superclass that implements the LoanConstants interface, as well as representing basic information about a loan.
 * Some input validation is also applied.
 * Assignment: 10
 * Name: Katherine Nelson
 * Date: 4/11/2022
 * Professor: Sheikh Shamsuddin
 * Class Code: CPSC-24500-002
 * File Name: Loan.java
 */

package homework10;

public abstract class Loan implements LoanConstants {
	protected String loanNumber;
	protected String customerLastName;
	protected double loanAmount;
	protected double interestRate;
	protected String term;
	
	public Loan() {
		super();
	}

	public Loan(String loanNumber, String customerLastName, double loanAmount, String term) {
		super();
		this.loanNumber = loanNumber;
		this.customerLastName = customerLastName;
		// More input validation testing will be done in main program to require user
		// to re-enter loan amount if loan amount is above maximum
		if (loanAmount > maximumLoanAmount) {
			this.loanAmount = 0;
		}
		else {
			this.loanAmount = loanAmount;
		}
		// Input validation for loan terms
		if (!term.equalsIgnoreCase(shortTerm) && !term.equalsIgnoreCase("one year") &&
			!term.equalsIgnoreCase(mediumTerm) && !term.equalsIgnoreCase("three years") &&
			!term.equalsIgnoreCase(longTerm) && !term.equalsIgnoreCase("five years")){
			this.term = shortTerm;
		}
		else if (term.equalsIgnoreCase("one year")) {
			this.term = shortTerm;
		}
		else if (term.equalsIgnoreCase("three years")) {
			this.term = mediumTerm;
		}
		else if (term.equalsIgnoreCase("five years")) {
			this.term = longTerm;
		}
		else {
			this.term = term;
		}
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		// More input validation testing will be done in main program to require user
		// to re-enter loan amount if loan amount is above maximum
		if (loanAmount > maximumLoanAmount) {
			this.loanAmount = 0;
		}
		else {
			this.loanAmount = loanAmount;
		}
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		// Input validation for loan terms
		if (!term.equalsIgnoreCase(shortTerm) && !term.equalsIgnoreCase("one year") &&
				!term.equalsIgnoreCase(mediumTerm) && !term.equalsIgnoreCase("three years") &&
				!term.equalsIgnoreCase(longTerm) && !term.equalsIgnoreCase("five years")){
				this.term = shortTerm;
			}
			else if (term.equalsIgnoreCase("one year")) {
				this.term = shortTerm;
			}
			else if (term.equalsIgnoreCase("three years")) {
				this.term = mediumTerm;
			}
			else if (term.equalsIgnoreCase("five years")) {
				this.term = longTerm;
			}
			else {
				this.term = term;
			}
	}

	@Override
	abstract public String toString();
}
