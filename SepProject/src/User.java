import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User extends JFrame implements ActionListener {
    private JTextField nameField, idField;
    private JRadioButton ghatButton, crematoriaButton, riverfrontButton;    private JButton submitButton;

    public User() {
        super("User Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel idLabel = new JLabel("User ID:");
        idField = new JTextField(10);

        ghatButton = new JRadioButton("Ghat");
        crematoriaButton = new JRadioButton("Crematoria");
        riverfrontButton = new JRadioButton("Riverfront");

        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(ghatButton);
        locationGroup.add(crematoriaButton);
        locationGroup.add(riverfrontButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // add components to container
        JPanel container = new JPanel(new GridLayout(4, 2));
        container.add(nameLabel);
        container.add(nameField);
        container.add(idLabel);
        container.add(idField);
        container.add(ghatButton);
        container.add(crematoriaButton);
        container.add(riverfrontButton);
        container.add(submitButton);

        // set container properties
        setContentPane(container);
        pack();
        setLocationRelativeTo(null); // center window on screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            User user;

            if (ghatButton.isSelected()) {
                new Ghat(id, name);
            } else if (crematoriaButton.isSelected()) {
                new Crematoria(id, name);
            } else if (riverfrontButton.isSelected()) {
                new Riverfront(id, name);
            } else {
                // no location selected
                JOptionPane.showMessageDialog(this, "Please select a location.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    public static void main(String[] args) {
        User gui = new User();
    }
}
