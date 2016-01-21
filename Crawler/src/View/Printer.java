package View;


import Service.Keeper;
import Service.Stats;
import Service.Worker;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nonseno on 2016-01-11.
 */
public class Printer {
    private Worker worker;
    private Stats stats;
    private Keeper keeper;
    private JTextArea taShowResults;
    private JLabel lShowStatsOne;
    private JLabel lShowStatsTwo;
    private ScheduledExecutorService scheduledExecutorService;

    public Printer( Worker worker, Keeper keeper, Stats stats, JTextArea taShowResults, JLabel lShowStatsOne, JLabel lShowStatsTwo) throws IOException {
        this.worker = worker;
        this.keeper = keeper;
        this.stats = stats;
        this.taShowResults = taShowResults;
        this.lShowStatsOne = lShowStatsOne;
        this.lShowStatsTwo = lShowStatsTwo;
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(task,0,1, TimeUnit.SECONDS);
    }

    public void displayString(String sentence){
        SwingUtilities.invokeLater(() -> taShowResults.append(sentence + "\n"));

    }

    public void displaySentences(){
        if((keeper.getSentencesSize()>keeper.getIdSentence()) ) {
            SwingUtilities.invokeLater(() -> taShowResults.append(keeper.getSentence(keeper.getIdSentence())));
            keeper.incrementIdSentence();
        }
    }


    Runnable task = () -> {
        try{
            TimeUnit.SECONDS.sleep(10);
            displaySentences();
            lShowStatsOne.setText("Zebrano : "+ stats.getLinkStats() +"linkow/10s");
            lShowStatsTwo.setText("Zebrano : "+ stats.getWordStats() +"slow/strone");
        } catch (InterruptedException e) {
            displayString(e.getMessage());
        }
    };

}
