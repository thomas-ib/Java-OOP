package vendingmachine;

public enum Coin {
    FIVE_CENTS(5), TEN_CENTS(10), TWENTY_CENTS(20), FIFTY_CENTS(50), HUNDRED_CENTS(100);

    private int value;

    private Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static int[] parseCoins(String coins) {
        String[] numberCoinsInText = coins.split(",");
        int[] result = new int[numberCoinsInText.length];

        for (int i = 0; i < numberCoinsInText.length; i++) {
            result[i] = Integer.parseInt(numberCoinsInText[i]);
        }
        return result;
    }
}
