package utility;

import java.math.BigInteger;
import java.util.Random;

public class IbanGenerator {

    private final String randomBankNumber;
    private final String controlNumber;

    private IbanGenerator() {
        this.randomBankNumber = generateRandomNumber();
        this.controlNumber = calculateControlNumber();
    }

    public static String generateIban() {
        IbanGenerator ibanGenerator = new IbanGenerator();

        return "NL" + ibanGenerator.controlNumber + "INGB" + ibanGenerator.randomBankNumber;
    }

    private String calculateControlNumber() {
        String bankToNumber = "18231611";
        String country = "2321";
        String result;

        String mergedNumber = bankToNumber + randomBankNumber + country;
        BigInteger numberToCalculate = new BigInteger(mergedNumber);
        numberToCalculate = numberToCalculate.mod(BigInteger.valueOf(97));
        int parsedNumberToCalculate = numberToCalculate.intValue();
        parsedNumberToCalculate = 98 - parsedNumberToCalculate;
        result = String.valueOf(parsedNumberToCalculate);
        if (parsedNumberToCalculate < 10) {
            result = "0" + result;
        }

        return result;
    }

    private String generateRandomNumber() {
        Random rand = new Random();
        StringBuilder randomNumber = new StringBuilder(String.valueOf(rand.nextInt(Integer.MAX_VALUE)));

        while (randomNumber.length() < 10) {
            randomNumber.insert(0, "0");
        }

        return randomNumber.toString();
    }
}