package zad; /**
 * Created by Admin on 08.10.15.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PageReader {
    public FileReader fr;
    public String linia;
    public BufferedReader bfr;
    private int Lines,Brackets, EmptyLines;

    PageReader() {
        fr = null;
        linia = "";
        Lines=0;
        Brackets=0;
        EmptyLines=0;

    }

    public void Open(String plik) throws FileNotFoundException {
            fr = new FileReader(plik);
        bfr = new BufferedReader(fr);
    }

    //,masz kupe duplikacji kodu z kazdej z metod
    ///duzo zmiennych nieuzywanych
    //o wiele zgrabniej i ładniej wygladało uzywajac konstrukcji javy 8 takiej jak filtry i streamy
    //wszedzie te same catche, te same while....

    //faktycznie, troche bylo namieszane, sporo powtorzen, probowalem zrozumiec filtry i streamy, ale nie potrafilem
    //tego odniesc do moich ifow do konca, bede probowal w nastepnym projektach uzywac

    //zdaje mi sie, ze program jest juz zgrabniejszy i czytelniejszy ;)


    public void read() throws IOException{
        int lines = 0, starter = 0, ender = 0, brackets=0, emptyLines=0;
            while ((linia = bfr.readLine()) != null) {
                lines++;
                if (linia.contains("/*")) {
                    starter = lines;
                }
                if (linia.contains("*/")) {
                    ender = lines;
                    lines = lines - (1 + ender - starter);
                }
                if (linia.contains("//")) {
                    lines--;
                }
                if (linia.startsWith("{")) {
                    brackets++;
                }
                if (linia.endsWith("}")) {
                    brackets++;
                }
                if (linia.isEmpty()) {
                    emptyLines++;
                }
            }

        setVariables(lines,brackets,emptyLines);

    }

    public void setVariables(int l, int b, int e)
    {
        this.Lines=l;
        this.Brackets=b;
        this.EmptyLines=e;
    }

    public void close() throws IOException {
            fr.close();
    }

    public int getLines() {return Lines;}

    public int getBrackets() {return Lines-Brackets;}

    public int getEmptyLines() {return Lines-EmptyLines;}

    public int getEmptyBrackets() {return Lines-Brackets-EmptyLines;}

}


