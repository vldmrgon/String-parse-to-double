package com.company.ge;


public class MyDouble {

    private int countNumberAfterPoint = 1;
    private boolean isNegative = false;
    private boolean isPoint = false;
    private double result = 0.0;

    public double parseToDouble(String str) {

        checkEmptyString(str);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            validateChar(ch, i);
            processDigit(ch);
        }
        return isNegative ? -result : result;
    }

    private void validateChar(char ch, int index) {
        validateNegativeSymbol(ch, index);
        validatePoints(ch, index);
        validateNumbers(ch);
    }

    private void processDigit(char ch) {

        if (ch == '-') {
            isNegative = true;
            return;
        }

        if (ch == '.') {
            return;
        }

        int number = ch - '0';

        if (isPoint) {
            result = result + (Math.pow(0.1, countNumberAfterPoint) * number);
            countNumberAfterPoint++;
        } else {
            result = result * 10 + number;
        }
    }

    private void checkEmptyString(String string) {
        if (string == null || string.isBlank()) {
            throw new NumberFormatException("This string is empty");
        }
    }

    private void validateNegativeSymbol(char ch, int index) {
        if (ch == '-' && index != 0) {
            throw new NumberFormatException("Wrong negative format");
        }
    }

    private void validatePoints(char ch, int index) {
        if (ch == '.' && isPoint) {
            throw new NumberFormatException("Wrong string, contains two points");
        }
        if (ch == '.' && index == 0) {
            throw new NumberFormatException("Wrong string, the point is first symbol");
        } else if (ch == '.') {
            isPoint = true;
        }
    }

    private void validateNumbers(char ch) {
        int codeASCII = (int) ch;
        if ((codeASCII < 48 || codeASCII > 57) && codeASCII != 45 && codeASCII != 46) {
            throw new NumberFormatException("Impossible to parse. The string contains wrong symbols");
        }
    }
}