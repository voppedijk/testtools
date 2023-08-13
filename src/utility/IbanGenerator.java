package utility;

import java.math.BigInteger;
import java.util.Random;

public class IbanGenerator {

    public static String generateIban() {
        String controlNumber;
        String randomBankNumber;
        IbanGenerator ibanGenerator = new IbanGenerator();

        String result;

        do {
            randomBankNumber = ibanGenerator.generateRandomNumber();
            controlNumber = ibanGenerator.calculateControlNumber(randomBankNumber);
            result = "NL" + controlNumber + "INGB" + randomBankNumber;
        } while (!ibanGenerator.isValidIban(result));

        return "NL" + controlNumber + "INGB" + randomBankNumber;
    }

    private String calculateControlNumber(String randomBankNumber) {
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

    private boolean isValidIban(String iban) {
        StringBuilder sb = new StringBuilder(iban);
        String firstFourchars = iban.substring(0, 4);
        sb.delete(0, 4);
        sb.append(firstFourchars);
        sb.replace(0, 4, "18231611");
        sb.replace(sb.indexOf("NL"), sb.indexOf("NL") + 2, "2321");
        BigInteger resultBigInt = new BigInteger(sb.toString());
        BigInteger result = resultBigInt.mod(new BigInteger("97"));

        return result.intValue() == 1;
    }
}