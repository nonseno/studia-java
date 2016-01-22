package Service;

import View.Printer;
import properties.ConfigService;
import reader.ReaderFactory;
import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nonseno on 2016-01-13.
 */
public class Worker extends Thread{
    private Keeper keeper;
    private ReaderFactory readerFactory;
    private Searcher searcher;
    private ExecutorService pool;
    private Stats stats;

    public Worker(Stats stats, Keeper keeper) throws IOException {
        this.stats = stats;
        this.keeper = keeper;
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
            if(keeper.getExternalSize()>keeper.getIdLink()){
            readerFactory.setPath(keeper.getExternalLink(keeper.getIdLink()));
            pool.submit(new Searcher(readerFactory.create(),keeper, stats));
            keeper.incrementIdLink();
            }
    }


    public void run()
    {
        while(true)
            try {
                search();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
