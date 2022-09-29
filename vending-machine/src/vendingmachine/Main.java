package vendingmachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VendingMachine vendingMachine = new TextBasedVendingMachine();

        vendingMachine.displayProducts();

        String selectedProduct = scanner.nextLine();
        int selectProductNumber = Integer.parseInt(selectedProduct);
        vendingMachine.selectProduct(selectProductNumber);
        vendingMachine.displayEnterCoinsMessage();
        String userEnteredCoins = scanner.nextLine();
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
        vendingMachine.enterCoins(enteredCoins);
        vendingMachine.displayChangeMessage();
        scanner.close();
    }
}
