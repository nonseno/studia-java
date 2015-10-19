import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Admin on 07.10.15.
 */
public class Number {
    public Long[] tab;

    public Number(int rozmiar) {
        tab = new Long[rozmiar];
    }

    public void wyswietl()
    {
        int i=0;
        String napis= new String();
        for(Object o:tab)
        {
            napis=napis+tab[i];
            i++;
        }
        System.out.println(napis);
    }

}
