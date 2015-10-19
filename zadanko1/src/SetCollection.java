import java.util.*;

/**
 * Created by Admin on 06.10.15.
 */
public class SetCollection {
    public int ileLiczb;
    public Set lista;
    public Scanner wejscie;

    SetCollection()
    {
        ileLiczb=0;
        lista= new HashSet();
        wejscie = new Scanner(System.in);
    }
    //1 metoda wprowadz
    public void wprowadz()
    {

        System.out.println("Podaj ile chcesz wprowadzic liczb:");
        int ileLiczb = wejscie.nextInt();

        for(int i=0; i<ileLiczb; i++)
        {
            System.out.println("Podaj "+ (1+i) +" liczbe: ");
            long pomocnicza=wejscie.nextLong();
            lista.add(pomocnicza);
        }

    }

    //2 metoda wyswietl
    public void wyswietl()
    {
        System.out.println("Liczby podane przez uzytkownika: ");
        int i=1;
        for(Object object: lista)
        {
            Long element = (Long) object;
            System.out.println(i+" liczba: "+element);
            i++;
        }
    }


    //3 rozbicie na cyfry
    public Number[] zrobRozmiary()
    {
        int rozmiarListy=this.lista.size();
        Number[] liczby=new Number[rozmiarListy];
          int i=0, j=0;
        for(Object o : this.lista)
        {
            Long element=(Long)o;
            Long elementPom=element;
            while(elementPom!=0)
            {
                elementPom=elementPom/10;
                j++;
            }
            liczby[i] = new Number(j);
            j=0;
            while(element!=0)
            {
                liczby[i].tab[j]=element%10;
                element=element/10;
                j++;
            }
            j=0;
            i++;
        }

        //sortowanie malejace

         i=0;
        for(Object o:liczby) {
            Arrays.sort(liczby[i].tab, Collections.reverseOrder());
            i++;
        }

        return liczby;
    }

}
