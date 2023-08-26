package utils;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardUtils {
    public static String getClipboardContent() throws IOException, UnsupportedFlavorException {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public static void addSystemClipBoardLister(FlavorListener flavorListener) {
        Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(flavorListener);
    }
}
