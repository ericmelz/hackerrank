package hackerrank.exceptions.secure;

import org.apache.tomcat.util.buf.CharsetUtil;

public class Encrypter {
    private static Validator validator = new Validator();

    public static String getEncryptedName(String name) {
        if (validator.validate(name)) {
            name = name.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for (int i = name.length() - 1; i >= 0; i--) {
                char c = name.charAt(i);
                sb.append(c);
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Try again with valid name");
    }
}
