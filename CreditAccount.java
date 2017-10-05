import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Pajan Panahian-Larki, Ammar
 *
 */
public class CreditAccount {
	
	private Double balance;
	private int accountNumber;
	private int limit;
	private String SSN;
	private boolean monthlyFixedFee;
	private String status;
	
	private static ArrayList<CreditAccount> accountList = new ArrayList<CreditAccount>();
	
	public CreditAccount(Double bal, int ac, int lim, String socSec) {
		balance = bal;
		accountNumber = ac;
		limit = lim;
		SSN = socSec;
		status = "open";
		accountList.add(this);
	}
	
	// This is to prevent the creation of accounts with lacking information
	private CreditAccount() {}
	
	private Double withdrawAmount(Double amount) {
		assert ((status == "open") || (status == "cancelled") && (amount > balance));
		balance =- amount;
		System.out.printf("Withdrawing: %1.2f", amount);
		return amount;
	}
	
	private void depositAmount(Double amount) {
		assert ((status == "open") || (status == "cancelled"));
		balance =+ amount;
	}
	
	public void cancelAccount() {
		this.status = "cancelled";
	}
	
	public void suspendAccount() {
		this.status = "suspended";
	}
	
	public void reactivateAccount() {
			this.status = "open";
	}
	
	public double getBalance() {
		assert ((status == "open") || (status == "cancelled"));
		return this.balance;
	}
	
	public void terminateAccount() {
		for(int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i) == this) {
				accountList.remove(i);
				break;
			}
		}	
	}

	public void setOverdraftOption(boolean monthly) {
		assert ((status == "open") || (status == "cancelled"));
		if (monthly = true) {
			this.monthlyFixedFee = true;
		}
		else 
			this.monthlyFixedFee = false;
	}
	
	public void setLimit(int lim){
		assert ((status == "open") || (status == "cancelled"));
		this.limit = lim;
	}
	
	public void transferAmount(BankAccount act, double amount) {
		assert ((status == "open") || (status == "cancelled"));

			if (this.balance > amount) {
				this.balance -= amount;
				act.balance += amount;
			} else {
				System.out.println("Insufficient funds");
			}
		}
}