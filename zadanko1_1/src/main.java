

/**
 * Created by Admin on 05.10.15.
 */
//nazwy klas z duzych liter ^ - wyrzucalo sporo bledow przy zamianie nazy klasy i pliku na wielka litere, bede o tym pamietal, reszta poprawiona, duzo usuniete :)
public class main {


    //kod piszemy po angielsku
    public static void main(String[] args) {
//a to [po co? - pierw jak probowalem robic poprzez maven'a to wyrzucalo mi wiele bezsensownych bledow i na stackoverflow polecali te komenende
        //ale w sumie pozniej przerzucilem do normalnego projektu i juz bylo zbyteczne i zapomnialem usunac (zostawiam teraz by wiadomo bylo o co chodzi) ^
        //@SuppressWarnings( "deprecation" )

        SetCollection Temp = new SetCollection();
        System.out.println("Podaj liczby w jednej lini po przecinku:");
        Temp.insert();
        Temp.SplitNSort();
        //lista zamiast tablicy&

        System.out.println("Najwieksza liczba mozliwa po zamianie miejsc: ");
        Temp.LastList.forEach(s-> System.out.println(s));

    }
}

