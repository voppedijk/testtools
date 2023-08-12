import utility.CopyToClipboard;
import utility.IbanGenerator;

public class Main {
    public static void main(String[] args) {
        String result = IbanGenerator.generateIban();
        CopyToClipboard.putInClipboard(result);
        System.out.println("'" + result + "' copied to clipboard!");
    }
}