package hackerrank.problems.identicaldistro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int cardTypesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cardTypes = new ArrayList<>();

        for (int i = 0; i < cardTypesCount; i++) {
            int cardTypesItem = Integer.parseInt(bufferedReader.readLine().trim());
            cardTypes.add(cardTypesItem);
        }

        int result = IdenticalDistribution.cardPackets(cardTypes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}