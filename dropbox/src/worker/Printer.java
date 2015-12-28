package worker;


import javax.swing.*;

/**
 * Created by Admin on 24.12.15.
 */
public class Printer {

    public JTextArea notepad = new JTextArea();
    public JLabel label = new JLabel();

    public Printer(JTextArea notepad,JLabel label)
    {
        this.notepad=notepad;
        this.label=label;
    }


    public void displayString(String display)
    {
        SwingUtilities.invokeLater(() -> notepad.append(display));
    }

    public void displayLabel(String display)
    {
        SwingUtilities.invokeLater(()-> label.setText(display));
    }

}
