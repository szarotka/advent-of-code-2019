package task4;

import java.util.stream.IntStream;

public class Task4 {

    public long findAllPasswordsWithoutLargerGroups() {
        return IntStream.range(356261, 846303)
                .filter(password -> validTwoAdjacentDigitsWithoutGroups(password) && validNeverDecreases(password))
                .count();
    }

    private boolean validTwoAdjacentDigitsWithoutGroups(int password) {
        char[] chars = passwordToChars(password);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]
                    && (i == chars.length - 1 || chars[i] != chars[i + 1])
                    && (i == 1 || chars[i - 2] != chars[i - 1])) {
                return true;
            }
        }
        return false;
    }

    public long findAllPasswords() {
        return IntStream.range(356261, 846303)
                .filter(password -> validTwoAdjacentDigits(password) && validNeverDecreases(password))
                .count();
    }

    private boolean validTwoAdjacentDigits(int password) {
        char[] chars = passwordToChars(password);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean validNeverDecreases(int password) {
        char[] chars = passwordToChars(password);
        for (int i = 1; i < chars.length; i++) {
            if (Integer.parseInt(String.valueOf(chars[i - 1])) > Integer.parseInt(String.valueOf(chars[i]))) {
                return false;
            }
        }
        return true;
    }

    private char[] passwordToChars(int password) {
        String code = String.valueOf(password);
        return code.toCharArray();
    }

}
