package utility;

import java.math.BigInteger;
import java.util.Random;

public class IbanGenerator {

    public static String generateIban() {
        IbanGenerator ibanGenerator = new IbanGenerator();

        return ibanGenerator.calculateControlNumber();
    }

    private String calculateControlNumber() {
        String bankToNumber = "18231611";
        String bank = generateRandomNumber();
        String country = "2321";
        String controlNumber;
        String result;

        String mergedNumber = bankToNumber + bank + country;
        BigInteger numberToCalculate = new BigInteger(mergedNumber);
        numberToCalculate = numberToCalculate.mod(BigInteger.valueOf(97));
        int parsedNumberToCalculate = numberToCalculate.intValue();
        parsedNumberToCalculate = 98 - parsedNumberToCalculate;
        controlNumber = String.valueOf(parsedNumberToCalculate);
        if (parsedNumberToCalculate < 10) {
            controlNumber = "0" + controlNumber;
        }

        result = "NL" + controlNumber + "INGB" + bank;

        return result;
    }

    private String generateRandomNumber() {
        Random rand = new Random();
        String randomNumber = String.valueOf(rand.nextInt(Integer.MAX_VALUE));

        while (randomNumber.length() < 10) {
            randomNumber = "0" + randomNumber;
        }

        return randomNumber;
    }
}