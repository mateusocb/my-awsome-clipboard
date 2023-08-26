import dao.ClipDAO;
import view.MainScreen;

import javax.swing.*;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(() -> {
            var mainScreen = new MainScreen();

            mainScreen.show();
        });
    }
}
