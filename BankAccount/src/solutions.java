import FormatIO.*;

public class solutions 
{

   public static void main(String[] arg)
   {
      
     /* 
      * Bank Account Opening.
      * 
      * This part of the program asks the user to provide a bank
      * account number (possibly including alphabetic characters
      * like, e.g., in "ABCD1234") and an initial deposit (an
      * amount of money).
      * 
      * Once the above information has been entered, a file with
      * the name including the account number ("account ABCD1234.txt")
      * is written. The file includes the bank account number and
      * the initial balance.
      * 
      * The above operations are repeated a second time to open
      * a second account.
      * 
      */
      
      Console con = new Console("Open New Bank Accounts") ;
      
      // Acquisition of first account number
      
      con.print("Enter first bank account number: ") ;
      String accountNumber = con.readLine() ;
      
      // Acquisition of initial balance for first account 
      
      con.print("Enter initial balance of account "+accountNumber+": £") ;
      double initialDeposit = con.readDouble() ;
      
      // Writing first account file
      
      String fileName = "account-"+accountNumber+".txt" ; 
      String accountLine = accountNumber+" "+initialDeposit ;
      
      FileOut fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      
      con.println("Account file <"+fileName+"> written") ;
   
      fout.close() ;
         
      // Acquisition of second account number
      
      con.print("\nEnter second bank account number: ") ;
      accountNumber = con.readLine() ;
      
      // Acquisition of initial balance for second account 
      
      con.print("Enter initial balance of account "+accountNumber+": £") ;
      initialDeposit = con.readDouble() ;
      
      // Writing second account file
      
      fileName = "account-"+accountNumber+".txt" ; 
      accountLine = accountNumber+" "+initialDeposit ;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      
      con.println("Account file <"+fileName+"> written") ;
   
      fout.close() ;
         
      /* 
       * Payment.
       * 
       * This part of the program asks the user for the details of the apartment
       * rental and the account to be charged.
       * 
       */
      
      con.println("\n\nPayment") ;
      
      // Acquisition of data for paying apartment rental
      
      con.print("Enter number of apartment rental months to be paid: ") ;
      int months = con.readInt() ;
      
      con.print("Enter the monthly price of the apartment: £") ;
      double rental = con.readDouble() ;
      
      double price = rental * months ;
      
      con.println(String.format("The total price is £%.2f", price)) ;
      
      // Acquisition of account to be charged
      
      con.print("Enter account number to be debited: ") ;
      accountNumber = con.readLine() ;
      
      // Update of the balance
      
      fileName = "account-"+accountNumber+".txt" ;
      FileIn fin = new FileIn(fileName) ;
      
      accountNumber = fin.readWord();
      double balance = fin.readDouble();
      
      fin.close() ;
      
      balance = balance - price ;
      accountLine = accountNumber+" "+balance ;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      fout.close() ;
      
      con.println("Account file <"+fileName+"> written") ;
      

      con.println(String.format("The new balance of account %s is £%.2f",accountNumber,balance)) ;
   
   
     /* 
      * Money Transfer.
      * 
      * This part of the program allows the transfer of money from
      * one bank account to the other.
      * 
      */
      
      con.println("\n\nMoney Transfer") ;
      
      // Acquisition of data for the transfer
      
      con.print("Enter the amount of money to be transferred: £") ;
      double transferAmount = con.readDouble() ;
      
      // Acquisition of accounts to be debited / credited
      
      con.print("Enter account number to withdraw the money from: ") ;
      String accountFrom = con.readLine() ;
      
      con.print("Enter the account number to deposit the money into: ") ;
      String accountTo = con.readLine() ;
      
      // Update of the balance for the account from which the money
      // is transferred from.
      
      fileName = "account-"+accountFrom+".txt" ;
      fin = new FileIn(fileName) ;
      
      accountNumber = fin.readWord();
      balance = fin.readDouble();
      
      fin.close() ;
      
      balance = balance - transferAmount ;
      accountLine = accountFrom+" "+balance ;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      fout.close() ;
      
      con.println("Account file <"+fileName+"> written") ;
      
      con.println(String.format("The new balance of account %s is £%.2f", accountFrom, balance)) ;
      
      // Update of the balance for the account from which the money
      // is transferred to.
      
      fileName = "account-"+accountTo+".txt" ;
      fin = new FileIn(fileName) ;
      
      accountNumber = fin.readWord();
      balance = fin.readDouble();
      
      fin.close() ;
      
      balance = balance + transferAmount ;
      accountLine = accountTo+" "+balance ;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      fout.close() ;
      
      con.println("Account file <"+fileName+"> written") ;
      
      con.println(String.format("The new balance of account %s is £%.2f" ,accountTo, balance)) ;
      
      
      /*
       * 
       * This part of the program allows a transfer from an account
       * in pounds to an account in dollars
       * 
       */
      
      con.println("\n\nCurrency Exchange") ;
      
      // Acquisition of account number for account in dollars
      
      con.print("Enter third bank account number (to hold dollars): ") ;
      accountNumber = con.readLine() ;
   
      // Acquisition of initial balance for account in dollars
      
      con.print("Enter initial balance: $") ;
      initialDeposit = con.readDouble() ;
      
      // Writing account file
      
      fileName = "account-"+accountNumber+".txt" ; 
      accountLine = accountNumber+" "+initialDeposit ;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      
      con.println("Account file <"+fileName+"> written") ;
   
      fout.close() ;
         
      // Acquisition of account from which the money must be transferred
      
      con.print("Enter account number to withdraw the money from: ") ;
      accountFrom = con.readLine() ;
      
      con.print("Enter the amount of money to be transferred: £") ;
      transferAmount = con.readDouble() ;
      
      // Acquisition of conversion rate and commission fee
      
      con.print("Enter the conversion rate between pounds and dollars: ") ;
      double conversionRate = con.readDouble() ;
      
      con.print("Enter the commission fee (percentage of transferred amount) to be paid: ") ;
      double fee = con.readDouble() ;
      
      // Calculation of amounts to be debited / credited
      
      double debitAmount = transferAmount + transferAmount*fee / 100.0 ;
      double dollarsAmount = transferAmount*conversionRate ;
      
      // Update of the balance for the account from which the money
      // is transferred.
      
      fileName = "account-"+accountFrom+".txt" ;
      fin = new FileIn(fileName) ;
      
      accountFrom = fin.readWord();
      balance = fin.readDouble();
      
      fin.close() ;
      
      balance = balance - debitAmount ;
      accountLine = accountFrom+" "+balance;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      fout.close() ;
      
      con.println("Account file <"+fileName+"> written") ;

      con.println(String.format("The new balance of account %s is £%.2f", accountFrom, balance)) ;
      
      // Update of the balance of the count in dollars
      
      fileName = "account-"+accountNumber+".txt" ;
      fin = new FileIn(fileName) ;
      
      accountNumber = fin.readWord();
      balance = fin.readDouble();
      
      fin.close() ;
      
      balance = balance + dollarsAmount ;
      accountLine = accountNumber+" "+balance;
      
      fout = new FileOut(fileName) ;
      fout.println(accountLine) ;
      fout.close() ;
      
      con.println("Account file <"+fileName+"> written") ;
      
      con.println(String.format("The new balance of account %s is $%.2f", accountNumber, balance)) ;
   }
}
