package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.account.Account;
import model.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @AllArgsConstructor @Builder
public class AccountTransactionDTO {
    private Account account;
    private List<Transaction> transactions = new ArrayList<>();
    
    // public AccountTransactionDTO(Account account, List<Transaction> transactions) {
    //     this.account = account;
    //     this.transactions = transactions;
    // }
}
