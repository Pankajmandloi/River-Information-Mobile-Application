import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Ghat {
    private String username;
    private int userId;

    public Ghat(int userId, String username) {
        this.username = username;
        this.userId = userId;
        showGhat();
    }

    public void showGhat() {
        JFrame frame = new JFrame("Ghat Information");

        JLabel label = new JLabel("Welcome " + username + " (User ID: " + userId + ")");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label, BorderLayout.NORTH);

        JTable table = new JTable();
        table.setAutoCreateRowSorter(true);
        table.setFillsViewportHeight(true);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Asus\\IdeaProjects\\SepProject\\src\\ghat-info.csv"));
            String[] header = reader.readLine().split(",");
            DefaultTableModel model = new DefaultTableModel(header, 0);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                model.addRow(row);
            }
            reader.close();
            table.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error reading file.");
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
