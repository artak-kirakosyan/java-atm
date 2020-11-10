import java.util.LinkedHashMap;
import java.util.Scanner;

public abstract class CardReaderAbstract {
    private Card card;
    private final Scanner scanner;

    CardReaderAbstract() {
        scanner = new Scanner(System.in);
        card = null;
    }

    public LinkedHashMap<CardInfo, String> readCard() {
        LinkedHashMap<CardInfo,String> cardIdentifyInfo = new LinkedHashMap<>();
        String info;
        for (CardInfo cardInfo : CardInfo.values()) {
            System.out.print("Insert your " + cardInfo + ": ");
            info = scanner.nextLine();
            cardIdentifyInfo.put(cardInfo, info);
        }
        card = new Card(cardIdentifyInfo);
        return cardIdentifyInfo;
    }

    public boolean cardIsValid() {
        String cardNumber = card.getCardNumber();
        return cardNumber.length() <= Card.ID_MAX_LENGTH && cardNumber.length() >= Card.ID_MIN_LENGTH;
    }

    public void ejectCard() {
        card = null;
    }

    public void eatCard() {
        System.out.println("Please contact card service");
    }
}
