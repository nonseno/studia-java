package service;
import com.dropbox.core.*;
import worker.Printer;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by Admin on 22.12.15.
 */

public class FileSender {

    AtomicInteger stats = new AtomicInteger(0);
    DbxClient client;
    Client clientHandler;
    Printer printer;

    public FileSender(Printer printer) throws IOException, DbxException {
        clientHandler = new Client();
        this.printer=printer;
    }

    public void send(String path) throws IOException, DbxException {sendFile(new File(path));
    }

    public  int getStats(){return stats.getAndSet(0);}

    private void sendFile(File f) throws DbxException, IOException {
        printer.displayString("new file " + f.getName()+"\n");
        client = clientHandler.getClient();
        try  {
            InputStream inputStream = new FileInputStream(f);
             client.uploadFile("/" + f.getName(),
                    DbxWriteMode.add(), f.length(), inputStream);
            printer.displayString("Uploaded: " + f.getName()+"\n");
        }
        catch(FileNotFoundException e)
        {
            printer.displayString(e.getMessage());
        }
        stats.incrementAndGet();
    }



}
