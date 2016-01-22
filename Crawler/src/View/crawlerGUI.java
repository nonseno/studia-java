package View;

import Service.Keeper;
import Service.Stats;
import Service.Worker;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * Created by nonseno on 2016-01-19.
 */
public class crawlerGUI extends JFrame {
    private JTextArea taShowResults;
    private JScrollPane spShowResults;
    private JLabel lShowStatsOne;
    private JLabel lShowStatsTwo;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new crawlerGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



    public crawlerGUI() throws IOException {
        super("Crawler");
        setLayout(new MigLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taShowResults = new JTextArea();
        spShowResults = new JScrollPane(taShowResults);
        lShowStatsOne = new JLabel("Zebrano: 0 linkow/10s");
        lShowStatsTwo = new JLabel("Zebrano: 0 slow/strone");

        createUIComponents();

        Stats stats = new Stats();
        Keeper keeper = new Keeper();
        Worker worker = new Worker(stats, keeper);
        Printer printer = new Printer(worker, keeper, stats, taShowResults,lShowStatsOne,lShowStatsTwo);


        worker.onStart(askForWord().toLowerCase());
        worker.start();

    }


    private void createUIComponents(){
        add(spShowResults, "w 300!, h 500!");
        add(lShowStatsOne, "dock east, w 150!, h 20!");
        add(lShowStatsTwo, "dock east, w 150!, h 20!");
        pack();

    }




    private String askForWord(){

        JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Podaj slowo:  ", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
        JTextField word = new JTextField();
        controls.add(word);
        p.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(
                this, p, "Say which word would you like to search for", JOptionPane.QUESTION_MESSAGE);
            return word.getText();
    }




}
