package zad;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 01.11.15.
 */
public class LineCounter { public FileReader fr;
    private int Lines,Brackets, EmptyLines;

   public LineCounter() {
        Lines=0;
        Brackets=0;
        EmptyLines=0;
   }


    public void lines(ArrayList<String> file) throws IOException {
        int lines = 0, starter = 0, ender = 0, brackets=0, emptyLines=0;

        for(String s:file){
            lines++;
            if (s.contains("/*")) {
                starter = lines;
            }
            if (s.contains("*/")) {
                ender = lines;
                lines = lines - (1 + ender - starter);
            }
            if (s.contains("//")) {
                lines--;
            }
            if (s.startsWith("{")) {
                brackets++;
            }
            if (s.endsWith("}")) {
                brackets++;
            }
            if (s.isEmpty()) {
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



    public int getLines() {return Lines;}

    public int getBrackets() {return Lines-Brackets;}

    public int getEmptyLines() {return Lines-EmptyLines;}

    public int getEmptyBrackets() {return Lines-Brackets-EmptyLines;}

}
