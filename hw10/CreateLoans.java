/* This program demonstrates the use of Java GUI features through Java classes (superclass (Java interface implemented in superclass) and subclasses) and
 * objects by allowing a user to enter information in a JOptionPane.showInputDialog for 5 of a certain type of (business or personal) loan, which is then
 * stored in a JavaArrayList (using loop structures). When the user is done inputting data, the information is then displayed in a JTextArea within a 
 * JOptionPane.showMessageDialog (also using loop structures).
 * Some methods are also polymorphically invoked using instanceof.
 * Some input validation is also applied.
 * Assignment: 10
 * Name: Katherine Nelson
 * Date: 3/27/2022
 * Professor: Sheikh Shamsuddin
 * Class Code: CPSC-24500-002
 * File Name: CreateLoans.java
 */

package homework10;
import java.util.ArrayList;
import java.lang.Math;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CreateLoans {

	public static void main(String[] args) {
		ArrayList<Loan> loanArray = new ArrayList<Loan>(5);
		
		String prime = JOptionPane.showInputDialog(null, "What is the current prime interest rate?", "Prime Interest Rate", JOptionPane.INFORMATION_MESSAGE);
		if (prime == null) {
			System.exit(0);
		} // if statement
		double primeInterestRate = Double.parseDouble(prime);
		
		for (int i = 0; i < 5; i++) {
			String loanType = JOptionPane.showInputDialog(null, "What type of loan would you like to make?", "Loan #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);
			if (loanType == null) {
				System.exit(0);
			} // if statement
			
			while (!loanType.equalsIgnoreCase("business") && !loanType.equalsIgnoreCase("personal")) {
				loanType = JOptionPane.showInputDialog(null, "Please enter a VALID type of loan." + "\n" + 
			    "What type of loan would you like to make?", "Loan #" + (i + 1), JOptionPane.ERROR_MESSAGE);
				if (loanType == null) {
					System.exit(0);
				} // if statement
			} // while loop
			
			String loanNum = JOptionPane.showInputDialog(null, "What is the number of your loan?", "Loan #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);
			if (loanNum == null) {
				System.exit(0);
			} // if statement
			
			String lastName = JOptionPane.showInputDialog(null, "What is your last name?", "Loan #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);
			if (lastName == null) {
				System.exit(0);
			} // if statement
			
			String amount = JOptionPane.showInputDialog(null, "How much money would you like for your loan?", "Loan #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);
			if (amount == null) {
				System.exit(0);
			} // if statement
			double amountOfLoan = Double.parseDouble(amount);
			
			String loanTerm = JOptionPane.showInputDialog(null, "How long should the term of the loan be?", "Loan #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);
			if (loanTerm == null) {
				System.exit(0);
			} // if statement
			
			if (loanType.equalsIgnoreCase("business")) {
				loanArray.add(new BusinessLoan(loanNum, lastName, amountOfLoan, loanTerm, primeInterestRate));
			} // if statement
			else if (loanType.equalsIgnoreCase("personal")) {
				loanArray.add(new PersonalLoan(loanNum, lastName, amountOfLoan, loanTerm, primeInterestRate));
			} // else if statement
		} // for loop
		
		JTextArea loanOutputTextArea = new JTextArea(30, 30);
		
		for (int j = 0; j < loanArray.size(); j++) {
			if (loanArray.get(j) instanceof BusinessLoan) {
				// Input validation testing for the amount of the loan if it was above the max
				while (loanArray.get(j).getLoanAmount() == 0) {
					String amount = JOptionPane.showInputDialog(null, "Please enter a VALID amount of money for the loan that does not exceed $500,000 for loan #" + (j + 1) + "\n"
							+ "How much money would you like for your loan?", "Loan #" + (j + 1) + " Amount Error", JOptionPane.ERROR_MESSAGE);
					if (amount == null) {
						System.exit(0);
					} // if statement
					double amountOfLoan = Double.parseDouble(amount);
					String loanNum = loanArray.get(j).getLoanNumber();
					String lastName = loanArray.get(j).getCustomerLastName();
					String loanTerm = loanArray.get(j).getTerm();
					loanArray.set(j, new BusinessLoan(loanNum, lastName, amountOfLoan, loanTerm, primeInterestRate));
				} // while loop
				
				// Calculating total amount of money owed at the due date (original loan amount + loan fee)
				int numOfMonths = 0;
				if (loanArray.get(j).getTerm().contains("1")) {
					numOfMonths = 1 * 12;
				} // if statement
				else if (loanArray.get(j).getTerm().contains("3")) {
					numOfMonths = 3 * 12;
				} // else if statement
				else if (loanArray.get(j).getTerm().contains("5")) {
					numOfMonths = 5 * 12;
				} // else if statement
				
				double interestRatePerMonth = loanArray.get(j).getInterestRate() / 100 / 12;
				
				double totalPaymentNumerator = ((loanArray.get(j).getLoanAmount() * interestRatePerMonth) * Math.pow(1 + interestRatePerMonth, numOfMonths));
				double totalPaymentDenominator = (Math.pow(1 + interestRatePerMonth, numOfMonths) - 1);
				
				double totalPayment = totalPaymentNumerator / totalPaymentDenominator;
				
				totalPayment *= numOfMonths;
				
				// Display of data
				loanOutputTextArea.append("\t               Loan #" + (j + 1) + "\n");
				loanOutputTextArea.append(loanArray.get(j).toString() + "\n");
				loanOutputTextArea.append("Total Payment: $" + String.format("%.2f", totalPayment) + "\n");
				loanOutputTextArea.append("\n");
			} // if statement
				
			else if (loanArray.get(j) instanceof PersonalLoan) {
				// Input validation testing for the amount of the loan if it was above the max
				while (loanArray.get(j).getLoanAmount() == 0) {
					String amount = JOptionPane.showInputDialog(null, "Please enter a VALID amount of money for the loan that does not exceed $500,000 for loan #" + (j + 1) + "\n"
							+ "How much money would you like for your loan?", "Loan #" + (j + 1) + " Amount Error", JOptionPane.ERROR_MESSAGE);
					if (amount == null) {
						System.exit(0);
					} // if statement
					double amountOfLoan = Double.parseDouble(amount);
					String loanNum = loanArray.get(j).getLoanNumber();
					String lastName = loanArray.get(j).getCustomerLastName();
					String loanTerm = loanArray.get(j).getTerm();
					loanArray.set(j, new PersonalLoan(loanNum, lastName, amountOfLoan, loanTerm, primeInterestRate));
				} // while loop
				
				// Calculating total amount of money owed at the due date (original loan amount + loan fee)
				int numOfMonths = 0;
				if (loanArray.get(j).getTerm().contains("1")) {
					numOfMonths = 1 * 12;
				} // if statement
				else if (loanArray.get(j).getTerm().contains("3")) {
					numOfMonths = 3 * 12;
				} // else if statement
				else if (loanArray.get(j).getTerm().contains("5")) {
					numOfMonths = 5 * 12;
				} // else if statement
				
				double interestRatePerMonth = loanArray.get(j).getInterestRate() / 100 / 12;
				
				double totalPaymentNumerator = ((loanArray.get(j).getLoanAmount() * interestRatePerMonth) * Math.pow(1 + interestRatePerMonth, numOfMonths));
				double totalPaymentDenominator = (Math.pow(1 + interestRatePerMonth, numOfMonths) - 1);
				
				double totalPayment = totalPaymentNumerator / totalPaymentDenominator;
				
				totalPayment *= numOfMonths;
				
				// Display of data
				loanOutputTextArea.append("\t               Loan #" + (j + 1) + "\n");
				loanOutputTextArea.append(loanArray.get(j).toString() + "\n");
				loanOutputTextArea.append("Total Payment: $" + String.format("%.2f", totalPayment) + "\n");
				loanOutputTextArea.append("\n");
			} // else if statement
		} // for loop
		
		JOptionPane.showMessageDialog(null, loanOutputTextArea, "Loan Data Display", JOptionPane.INFORMATION_MESSAGE);
	} // main()
} // CreateLoans
