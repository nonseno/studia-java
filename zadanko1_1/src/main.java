

/**
 * Created by Admin on 05.10.15.
 */
//nazwy klas z duzych liter ^ - wyrzucalo sporo bledow przy zamianie nazy klasy i pliku na wielka litere, bede o tym pamietal, reszta poprawiona, duzo usuniete :)
public class main {

    public static void main(String[] args) {


        SetCollection Temp = new SetCollection();
        GetShow tmp = new GetShow();
        System.out.println("Podaj liczby w jednej lini po przecinku:");
        Temp.setList(tmp.insert());
        //lista zamiast tablicy&

        System.out.println("Najwieksza liczba mozliwa po zamianie miejsc: ");
        tmp.show(Temp.SplitNSort());

    }
}

