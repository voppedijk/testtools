import utility.BsnGenerator;
import utility.CopyToClipboard;
import utility.IbanGenerator;

public class Main {
    public static void main(String[] args) {
        String result = IbanGenerator.generateIban();
        CopyToClipboard.putInClipboard(result);
        System.out.println("IBAN: " + result + " copied to clipboard!");

        System.out.println("Bsn:" + BsnGenerator.generate());
    }
}