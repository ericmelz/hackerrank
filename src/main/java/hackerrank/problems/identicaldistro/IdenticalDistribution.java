package hackerrank.problems.identicaldistro;

import java.util.List;

public class IdenticalDistribution {
    /*
     * Complete the 'cardPackets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY cardTypes as parameter.
     */

    public static int cardPackets(List<Integer> cardTypes) {

        int minExtraCards = Integer.MAX_VALUE;
        for (int numPackets = 2; numPackets <= 4; numPackets++) {
            int sum = 0;
            for (int numCards: cardTypes) {
                int cardsNeeded = (numCards % numPackets) == 0 ? 0 : numPackets - numCards % numPackets;
                sum += cardsNeeded;
            }
            if (sum <= minExtraCards) {
                minExtraCards = sum;
            }
        }
        return minExtraCards;
    }
}
