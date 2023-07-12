package hackerrank.exceptions.secure;

import java.util.Scanner;

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {
        String name = INPUT_READER.nextLine();

        try {
            System.out.println(Encrypter.getEncryptedName(name));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
