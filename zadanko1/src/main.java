import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Admin on 05.10.15.
 */
public class main {

    public static void main(String[] args) {
        //@SuppressWarnings( "deprecation" )

        SetCollection pomocnicza = new SetCollection();
        pomocnicza.wprowadz();
        //pomocnicza.wyswietl();
        Number[] liczby=pomocnicza.zrobRozmiary();
        int i=0;
        System.out.println("Najwieksza liczba mozliwa po zamianie miejsc: ");
        for(Object o:liczby) {
            System.out.println(1+i+" liczba:");
            liczby[i].wyswietl();
            i++;
        }

    }
}

