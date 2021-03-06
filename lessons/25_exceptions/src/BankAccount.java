/** A class for a bank account with complete encapsulation and the final keyword */
public final class BankAccount { // we declare the class final, we don't allow subclassing

  /** the account number: clearly private, clearly never changes, so it should be final */
  private final String accountNumber;  
  /** the amount of money in the account in cents: also private */
  private long balance; // we use long, not double, because an account cannot have "fractional" cents
  
  /** create a new bank account with balance 0 */
  public BankAccount(final String number){ // number parameter is final, it cannot be changed inside constructor
    this.accountNumber = number;                // why would we want to change it anyway..
  }
  
  /** get the account's balance */
  public final double getBalance() {  // the method is marked as final. If the class was not already marked as final,
    return this.balance;              // then it would still not be possible to override the method
  }
  
  /** add some money to the bank account */
  public final void deposit(final long amount) {
    if((amount > 0L) && (amount < 1_000_000_00L)) { // sanity check: you can only deposit a positive amount
      this.balance += amount;                       // of money, and anything above 1 million is probably an error
    } else { // an invalid amount cannot be put into the account
      System.out.println("Invalid deposit amount " + amount + //$NON-NLS-1$
          " for account " + this); //$NON-NLS-1$
    }
  }
  
  /** withdraw some money from the bank account */
  public final void withdraw(final long amount) {
    if((amount > 0L) && (amount < 1_000_00L)) { // sanity check: you can only withdraw a positive amount of        
      this.balance -= amount;                   // money and at most 1000 RMB at once
    } else {
      System.out.println("Invalid withdrawal amount " + amount + //$NON-NLS-1$
          " for account " + this); //$NON-NLS-1$
    }
  }
  
  @Override
  public final String toString() {
    return '(' + this.accountNumber + ": " + this.balance + ')'; //$NON-NLS-1$
  }
}
