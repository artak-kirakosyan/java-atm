import java.util.ArrayList;

public abstract class CustomerAbstract implements CustomerInterface{
    private final String customerID;
    private final ArrayList<Account> accounts;
    private String phoneNumber;
    private String email;
    private String name;
    private String surname;
    private final int INITIAL_ACCOUNT_COUNT = 9;

    public CustomerAbstract(String customerID, String phoneNumber, String email, String name, String surname) {
        this.customerID = customerID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.surname = surname;
        accounts = new ArrayList<>(INITIAL_ACCOUNT_COUNT);
    }

    public String getCustomerID() {
        return customerID;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        for (Account account:accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Card getCardByCardNumber(String cardNumber) {
        for (Account account:accounts) {
            if (!(account instanceof CardAccount)) {
                continue;
            }
            CardAccount cardAccount = (CardAccount) account;
            Card currentCard = cardAccount.getCardByCardNumber(cardNumber);
            if (currentCard != null) {
                return currentCard;
            }
        }
        return null;
    }
}
