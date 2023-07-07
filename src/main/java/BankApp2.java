import db.DBConnection;
import dto.AccountTransactionDTO;
import java.sql.Connection;
import java.util.List;
import model.account.Account;
import model.account.AccountDAO;
import model.transaction.Transaction;
import model.transaction.TransactionDAO;

public class BankApp2 {
	
	public static void main(String[] args) {
		Connection connection = DBConnection.getInstance();
		// DI
		AccountDAO accountDAO = new AccountDAO(connection);
		TransactionDAO transactionDAO = new TransactionDAO(connection);
		
		try {
			int accountNumber = 1111;
			Account account = accountDAO.getAccountByNumber(accountNumber);
			List<Transaction> transactions = transactionDAO.getAllTransaction(accountNumber);
			AccountTransactionDTO dto = new AccountTransactionDTO(account, transactions);
   
			// 출력!!
			System.out.println("계좌번호 : "+dto.getAccount().getAccountNumber());
			System.out.println("계좌잔액 : "+dto.getAccount().getAccountBalance());
			System.out.println();
			dto.getTransactions().forEach(transaction -> {
				System.out.println("보내는분 : "+transaction.getTransactionWAccountNumber());
				System.out.println("받는분 : "+transaction.getTransactionDAccountNumber());
				System.out.println("보내는분 남은 잔액 : "+transaction.getTransactionWBalance());
				System.out.println("받는분 남은 잔액 : "+transaction.getTransactionDBalance());
				System.out.println("이체 금액 : "+transaction.getTransactionAmount());
				System.out.println("이체 날짜 : "+transaction.getTransactionCreatedAt());
			});
   
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
}