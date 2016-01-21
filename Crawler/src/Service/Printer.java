package Service;


import javax.swing.*;
import java.io.IOException;

/**
 * Created by nonseno on 2016-01-11.
 */
public class Printer {
    private JTextArea taShowResults;
    private JLabel lShowStatsOne;
    private JLabel lShowStatsTwo;

    public Printer( JTextArea taShowResults, JLabel lShowStatsOne, JLabel lShowStatsTwo) throws IOException {
        this.taShowResults = taShowResults;
        this.lShowStatsOne = lShowStatsOne;
        this.lShowStatsTwo = lShowStatsTwo;
    }

    public void displayLabelOne(String sentence){
        SwingUtilities.invokeLater(() -> lShowStatsOne.setText(sentence + "\n"));
    }

    public void displayLabelTwo(String sentence){
        SwingUtilities.invokeLater(() -> lShowStatsTwo.setText(sentence + "\n"));
    }

    public void displayString(String sentence){
        SwingUtilities.invokeLater(() -> taShowResults.append(sentence + "\n"));

    }

}
