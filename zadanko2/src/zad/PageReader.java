package zad; /**
 * Created by Admin on 08.10.15.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PageReader{
    public FileReader fr ;
    public String linia ;
    public BufferedReader bfr;

    PageReader()
    {
        fr = null;
        linia = "";

    }

    public void otworz(String plik)
    {
        try {
            fr = new FileReader(plik);
        } catch (FileNotFoundException e) {
            System.out.println("B£¥D PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }
        bfr= new BufferedReader(fr);
    }

    public int wczytaj()
    {
        int liczbaLini=0,odejmijPocz=0, odejmijKoniec=0;
        String pomocnicze="";
        try {
            while((linia = bfr.readLine()) != null){
                liczbaLini++;
                if(linia.contains("/*"))
               {
                   odejmijPocz=liczbaLini;
                }
                if(linia.contains("*/"))
                {
                    odejmijKoniec=liczbaLini;
                    liczbaLini=liczbaLini-(1+odejmijKoniec-odejmijPocz);
               }
                if(linia.contains("//"))
                {
                    liczbaLini--;
                }
            }
        } catch (IOException e) {
            System.out.println("B£¥D ODCZYTU Z PLIKU!");
            System.exit(2);
        }
        return liczbaLini;
    }


    public int wczytajNawiasy()
    {
        int liczbaLini=0,odejmijPocz=0, odejmijKoniec=0;
        String pomocnicze="";
        try {
            while((linia = bfr.readLine()) != null){
                liczbaLini++;
                if(linia.contains("/*"))
                {
                    odejmijPocz=liczbaLini;
                }
                if(linia.contains("*/"))
                {
                    odejmijKoniec=liczbaLini;
                    liczbaLini=liczbaLini-(1+odejmijKoniec-odejmijPocz);
                }
                if(linia.contains("//"))
                {
                    liczbaLini--;
                }
                if(linia.startsWith("{"))
                {
                    liczbaLini--;
                }
                if(linia.endsWith("}"))
                {
                    liczbaLini--;
                }
            }
        } catch (IOException e) {
            System.out.println("B£¥D ODCZYTU Z PLIKU!");
            System.exit(2);
        }
        return liczbaLini;
    }

    public int wczytajPuste()
    {
        int liczbaLini=0,odejmijPocz=0, odejmijKoniec=0;
        String pomocnicze="";
        try {
            while((linia = bfr.readLine()) != null){
                liczbaLini++;
                if(linia.contains("/*"))
                {
                    odejmijPocz=liczbaLini;
                }
                if(linia.contains("*/"))
                {
                    odejmijKoniec=liczbaLini;
                    liczbaLini=liczbaLini-(1+odejmijKoniec-odejmijPocz);
                }
                if(linia.contains("//"))
                {
                    liczbaLini--;
                }
                if(linia.isEmpty())
                {
                    liczbaLini--;
                }
            }
        } catch (IOException e) {
            System.out.println("B£¥D ODCZYTU Z PLIKU!");
            System.exit(2);
        }
        return liczbaLini;
    }

    public int wczytajNawiasyPuste()
    {
        int liczbaLini=0,odejmijPocz=0, odejmijKoniec=0;
        String pomocnicze="";
        try {
            while((linia = bfr.readLine()) != null){
                liczbaLini++;
                if(linia.contains("/*"))
                {
                    odejmijPocz=liczbaLini;
                }
                if(linia.contains("*/"))
                {
                    odejmijKoniec=liczbaLini;
                    liczbaLini=liczbaLini-(1+odejmijKoniec-odejmijPocz);
                }
                if(linia.contains("//"))
                {
                    liczbaLini--;
                }
                if(linia.startsWith("{"))
                {
                    liczbaLini--;
                }
                if(linia.endsWith("}"))
                {
                    liczbaLini--;
                }
                if(linia.isEmpty())
                {
                    liczbaLini--;
                }
            }
        } catch (IOException e) {
            System.out.println("B£¥D ODCZYTU Z PLIKU!");
            System.exit(2);
        }
        return liczbaLini;
    }


    public void zamknij()
    {
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("B£¥D PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }
}


