package ATM;

import java.util.*;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();
    private Map<Long, BankAccount> atmBankMap = new HashMap<>();
    private static long atmNumber = 123456;

    public void addBankAccount(BankAccount account) {
        accounts.add(account);
    }

    public Card issueATMCard(int accountNumber, int pin) throws IllegalArgumentException {
        Optional<BankAccount> account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst();


        if (account.isPresent()) {
            // Account found, perform action
            atmBankMap.put(atmNumber, account.get());
            return new Card(atmNumber++, account.get(), pin); // Return the card
        } else {
            // Account not found, throw error
            throw new IllegalArgumentException("Account with number " + accountNumber + " not found.");
        }
    }

    public BankAccount getAccount(Card card) {
        return atmBankMap.get(card.getCardNumber());
    }

}
