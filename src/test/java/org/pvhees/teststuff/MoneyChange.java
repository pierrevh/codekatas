package org.pvhees.teststuff;
/**
 * See SICP p.40-41*/
public class MoneyChange {
    // Returns the count of ways we can sum denominations[0...m-1] different coins to get amount
    private static int count(int[] denominations, int numberOfDenominations, int amount) {
        // If amount is 0 then there is 1 solution: do not include any coin
        if (amount == 0)
            return 1;

        // If amount is less than 0 then no solution exists
        if (amount < 0)
            return 0;

        // If there are no coins and amount is greater than 0, then no solution exist
        if (numberOfDenominations <= 0) // here amount >= 1
            return 0;

        // count is sum of the solutions (i) including denomination[m-1] and (ii) excluding denomination[m-1]
        return count(denominations, numberOfDenominations - 1, amount) +
                count(denominations, numberOfDenominations, amount - denominations[numberOfDenominations - 1]);
    }

    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25, 50};
        int numberOfDenominatios = denominations.length;
        System.out.println(count(denominations, numberOfDenominatios, 100));
    }

}
