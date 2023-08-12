package utility;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyToClipboard {

    public static void putInClipboard(String input) {
        Clipboard clip = Toolkit.getDefaultToolkit()
                .getSystemClipboard();
        StringSelection strse1 = new StringSelection(input);
        clip.setContents(strse1, strse1);
    }
}
