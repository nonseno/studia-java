import com.dropbox.core.DbxException;
import net.miginfocom.swing.MigLayout;
import service.FileSender;
import worker.Printer;
import service.StatsService;
import worker.FileListener;
import worker.StatsWorker;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 26.12.15.
 */
public class dropboxGUI extends JFrame{
    private JTextArea taShowResults;
    private JScrollPane spShowResults;
    private JLabel lShowStats;
    private  JFileChooser fc;
    private FileSender fileSender;
    private FileListener fileListener ;
    private StatsService statsService ;
    private StatsWorker statsWorker ;
    private Printer printer;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new dropboxGUI();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DbxException e) {
                e.printStackTrace();
            }
        });
    }


    public dropboxGUI() throws IOException, DbxException {
        super("Dropbox");
        setLayout(new MigLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taShowResults = new JTextArea();
        spShowResults = new JScrollPane(taShowResults);
        lShowStats = new JLabel("Wyslano: 0 plikow/10s");
        printer = new Printer(taShowResults,lShowStats);
        fileSender = new FileSender(printer);
        statsService = new StatsService(fileSender);
        statsWorker = new StatsWorker(statsService,printer);

        createUIComponents();

    }


    private void createUIComponents() throws IOException, DbxException {

        add(spShowResults, "w 300!, h 500!");
        add(lShowStats, "dock east, w 150!, h 20!");
        pack();
        taShowResults.setText("You have to choose a directory");
        String path;
        while((path=getDirectoryPath())==null)
        {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                taShowResults.setText(e.getMessage());
            }
        }
        taShowResults.setText(null);
        fileListener = new FileListener(fileSender, path,printer);
        fileListener.start();


    }

    private String getDirectoryPath()
    {
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        if(fc.showDialog(this,"Select")==JFileChooser.APPROVE_OPTION)
            return fc.getSelectedFile().toString();
        return null;
    }


}

