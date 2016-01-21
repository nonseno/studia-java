package Service;

import properties.ConfigService;
import reader.ReaderFactory;
import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nonseno on 2016-01-13.
 */
public class Worker{
    private Keeper keeper;
    private ReaderFactory readerFactory;
    private Searcher searcher;
    private ExecutorService pool;
    private Stats stats;
    private Printer printer;

    public Worker(Printer printer, Stats stats) throws IOException {
        this.printer= printer;
        this.stats = stats;
        keeper = new Keeper();
        readerFactory = new ReaderFactory();
        pool = Executors.newFixedThreadPool(new ConfigService().getThreadAmount());
    }

    public void onStart(String word) throws IOException {
        keeper.setSearchedWord(word);
        readerFactory.appendPath(word);
        searcher = new Searcher(readerFactory.create(),keeper, stats);
        searcher.setSource();
        searcher.findLinks();
        searcher.findWords();
      }

    public void search() throws IOException {
        while(true)
        {
            if(keeper.getExternalSize()>keeper.getIdLink()){
            readerFactory.setPath(keeper.getExternalLink(keeper.getIdLink()));
            pool.submit(new Searcher(readerFactory.create(),keeper, stats));
            keeper.incrementIdLink();
            }
            if((keeper.getSentencesSize()>keeper.getIdSentence()) ) {
                SwingUtilities.invokeLater(() -> printer.displayString(keeper.getSentence(keeper.getIdSentence())));
                keeper.incrementIdSentence();
            }
        }
    }


}
