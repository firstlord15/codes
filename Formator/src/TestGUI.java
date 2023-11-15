import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI extends JFrame {
    private JButton button = new JButton("Press button");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel(("input:"));
    private JRadioButton radioButton = new JRadioButton(("Select this"));
    private JRadioButton radioButton2 = new JRadioButton(("Select that"));
    private JCheckBox checkBox = new JCheckBox(("Check"), false);

    public TestGUI () {
        super("Simple Example");
        this.setBounds(850, 450, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton2);
        container.add(radioButton);
        radioButton.setSelected(true);
        container.add(radioButton2);
        container.add(checkBox);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + '"' +input.getText() + '"' + "\n";
            message += (radioButton.isSelected() ? "Radio #1":"Radio #2") + " is selected!\n";
            message += "Checkbox is " + (checkBox.isSelected() ? "Checked":"UnChecked");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
