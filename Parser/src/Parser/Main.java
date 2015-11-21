package Parser;

import java.io.IOException;

/**
 * Created by Admin on 14.11.15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reader read = new Reader();
        Worker work = new Worker(read.loadFile());
        Saver save = new Saver();
        work.setPerson();
        save.personListFile(work.getPersonList());
        save.errorsFile(work.getErrors());

    }
}
