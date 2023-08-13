package utility;

import java.util.Random;

public class BsnGenerator {

    private int bsn;

    public static int generate() {
        BsnGenerator bsnGenerator = new BsnGenerator();

        do {
            bsnGenerator.bsn = bsnGenerator.generateRandomNumber();
        } while (!bsnGenerator.passElevenTest(bsnGenerator.bsn));

        return bsnGenerator.bsn;
    }


    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(1_000_000_000 - 100_000_000) + 100_000_000;
    }

    private boolean passElevenTest(int bsn) {
        long sum = 0L;
        int elevenTestNrMultiplier = 9;
        String str = String.valueOf(bsn);

        for (int i = 0; i < str.length() - 1; i++) {
            sum = sum + ((long) str.charAt(i) * elevenTestNrMultiplier);
            elevenTestNrMultiplier = elevenTestNrMultiplier - 1;
        }

        sum += str.charAt(str.length() - 1);
        return sum % 11 == 0;
    }
}