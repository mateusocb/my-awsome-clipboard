package view;

import dao.ClipDAO;
import service.ClipService;
import utils.ClipboardUtils;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.SQLException;

public class MainScreen {
    private ClipService clipService;

    public MainScreen() {
        this.clipService = new ClipService();
    }

    public void show() {
        var frame = new JFrame("Clip");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ClipboardUtils.addSystemClipBoardLister((x) -> {
            try {
                ClipDAO.addByContent(ClipboardUtils.getClipboardContent());
            } catch (IOException | UnsupportedFlavorException | SQLException e) {
                throw new RuntimeException(e);
            }
        });

        var topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        var textField = new JTextField(50);

        topPanel.add(textField);

        var clips = clipService.findAll();


        var table = new JTable();

        var clipTableModel = new ClipTableModel(clips);

        table.setModel(clipTableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
