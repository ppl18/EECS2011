
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class abstract Account {

	// define var1, var2

	private Integer id = 0;
	
	private String SSN;

	private Double balance= 0.0;

	private Boolean noOverdraftProtection;
	private Boolean payPerUseFeeOverdraft;
	private Boolean monthlyFeeOverdraft;

	private final static Double maxOverDraftLimit = 5000.00;

	private static Double overDraftLimit;

	// private static double annualInterestRate = 0;

	private Date dateCreated = new Date();

	private static Boolean check = false;
	
	private static ArrayList<Account> AccountList = new ArrayList<Account>();
	private static ArrayList<AccountLog> AccountLogList = new ArrayList<AccountLog>();
	
	/*
	 * 
	 * Account(int newId, double newBalance, double newAnnualInterestRate) {
	 * 
	 * id = newId;
	 * 
	 * balance = newBalance;
	 * 
	 * annualInterestRate = newAnnualInterestRate;
	 * 
	 * }
	 */

	// accessor/mutator methods for id, balance, and annualInterestRate

	public void getId() {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			this.id = id;
		}

	}

	public Double getBalance() {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
			return null;
		} else {
			return balance ;
			activity.add(Double.toString(balance));
		}
		

	}
	/*
	 * public void getAnnualInterestRate() {
	 * 
	 * this.annualInterestRate = annualInterestRate;
	 * 
	 * }
	 */

	public void setId(int newId) {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			id = newId;
		}

	}

	public void setBalance(double newBalance) {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			balance = newBalance;
			activity.add(Double.toString(balance));
		}
	}
	/*
	 * public static void setAnnualInterestRate(double newAnnualInterestRate) {
	 * if (check == true) { System.out.
	 * println("Your account is suspended\nReactivate your account to do the operation"
	 * ); } else { annualInterestRate = newAnnualInterestRate; }
	 * 
	 * }
	 */

	// accessor method for dateCreated

	public void getDateCreated() {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			this.dateCreated = dateCreated;
		}

	}
	/*
	 * // define method getMonthlyInterestRate
	 * 
	 * void getMonthlyInterestRate() { if (check == true) { System.out.
	 * println("Your account is suspended\nReactivate your account to do the operation"
	 * ); } else { double monthlyInterestRate; monthlyInterestRate =
	 * annualInterestRate / 12 / 100 * balance; }
	 * 
	 * }
	 */

	// define method withdraw

	void withdraw(double amount) {

		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			if (amount > balance) {
				// Pay Per Use Overdraft Protection
				if (payPerUseFeeOverdraft && (balance + (overDraftLimit - 4) > amount)) {

					// $5.00 for each day
					balance -= 5;
					// acc2.balance -= amount;
					System.out.println("Balance with Pay Per use Fee Overdraft Protection\n" + (balance -= amount));
					activity.add(Double.toString(balance));
				}
				// Monthly Fixed Fee Overdraft Protection.
				else if (monthlyFeeOverdraft && (balance + (overDraftLimit - 3) > amount)) {
					// $4.00 per month
					balance -= 4;
					// acc3.balance -= amount;
					System.out.println("Balance with Monthly Fixed Fee Overdraft Protection\n" + (balance -= amount));
					activity.add(Double.toString(balance));
				}
				// the withdrawal will be declined, and a Non-Sufficient Funds
				// (NSF)
				// penalty will be charged.
				else if (((monthlyFeeOverdraft && payPerUseFeeOverdraft) == false)
						|| (balance + overDraftLimit < amount)) {
					// throw new IllegalArgumentException(
					// "The Withdrawal is declined\nThe balance must be more
					// than
					// the withdraw");
					System.out.println("the withdrawal is declined, and a Non-Sufficient Funds penalty will be charged.");
					activity.add(Double.toString(balance));
				}
			}

			else {
				balance -= amount;
				activity.add(Double.toString(balance));
			}
		}

	}

	// define method deposit

	void deposit(double amount) {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			balance += amount;
			activity.add(Double.toString(balance));
		}

	}

	public Account createAccount(Account newAccount) {
		newAccount = new Account();
		id = newAccount.id;
		balance = newAccount.balance;
		return newAccount;
	}

	static void suspendAccount(Account account) {
		check = true;
		activity.add("Account Suspended");
	}

	static void reactivateAccount(Account account) {
		check = false;
		activity.add("Account Reactivated");
	}

	void setOverdraftOption(boolean newNoOverdraftProtection, boolean newPayPerUseFeeOverdraft,
			boolean newMonthlyFeeOverdraft) {
		if (check == false) {
			noOverdraftProtection = newNoOverdraftProtection;
			payPerUseFeeOverdraft = newPayPerUseFeeOverdraft;
			monthlyFeeOverdraft = newMonthlyFeeOverdraft;
		} else {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
			activity.add(Double.toString(balance));
		}

	}

	static void setLimit(double newLimit) {
		if (newLimit > maxOverDraftLimit) {
			throw new IllegalArgumentException("The new limit is greater than the max limit ");
		} else {
			overDraftLimit = newLimit;
		}

	}

	public void cancelAccount(Account account) {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			Account acc = new Account();
			account = acc;
			account = null;
		}

	}

	public void transferAmount(double amount, Account otherAccount) {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
		} else {
			otherAccount.deposit(amount);
			balance = balance - amount;
			activity.add(Double.toString(balance));
		}
		
	}
	
	 void terminateAccount(Account account) {
		if (check == true) {
			System.out.println("Your account is suspended\nReactivate your account to do the operation");
			activity.add("Your account is suspended\nReactivate your account to do the operation");
		} else {
			for(int i = 0; i < AccountList.size(); i++) {
				if (AccountList.get(i) == this) {
					AccountList.remove(i);
					i = AccountList.size();
				}
			}	
			/*
			account.balance=null;
			account.dateCreated = null;
			account.id= null;
			account.monthlyFeeOverdraft= null;
			account.noOverdraftProtection = null;
			account.payPerUseFeeOverdraft = null;
			*/
			
			//account = null;
			
		}
	}

	public static void main(String[] args) {

		Account account = new Account(12,0);
		Account other = new Account();
		account.balance = 1000.0;
		other.balance = 500.0;

		account.setLimit(5000);
		account.setOverdraftOption(false, false, true);
		// suspendAccount(account);
		// account.withdraw(5996.0);
		//suspendAccount(account);
		//reactivateAccount(account);
		//terminateAccount(account);
		//account.getBalance();
		// account.cancelAccount(account);
		//account = null;
		//account.getBalance(account);
		//System.out.println("account: " + account.balance);
		account.terminateAccount(account);
		System.out.println(account.getBalance());
		
		//System.out.println(account.balance);
		//System.out.println("other: " +other.balance);

	}

}
