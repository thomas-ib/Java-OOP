package vendingmachine;

public interface Calculator {
    int calculateTotal(CoinBundle enteredCoins);

    CoinBundle calculateChange(int amoungMoneyToReturn);
    
}
