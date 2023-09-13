package io.school.validate;

import io.school.NotNull;

import java.util.regex.Pattern;

public interface NameParser {
    static String parseName(@NotNull String fullName) {
        if (isValidName(fullName)) {
            return formatName(fullName);
        }
        return null;
    }

    private static boolean isValidName(String fullName) {
        return Pattern.matches("^[a-zA-Z'\\s]+$", fullName);
    }

    private static String formatName(String fullName) {
        if (fullName.contains(" ")) {
            return fullName;
        } else {
            StringBuilder parsedName = new StringBuilder();
            boolean lastCharWasLowerCase = false;

            for (int i = 0; i < fullName.length(); i++) {
                char currentChar = fullName.charAt(i);

                if (Character.isUpperCase(currentChar) && lastCharWasLowerCase) {
                    parsedName.append(' ');
                }

                parsedName.append(currentChar);
                lastCharWasLowerCase = Character.isLowerCase(currentChar);
            }

            return parsedName.toString();
        }
    }
}
