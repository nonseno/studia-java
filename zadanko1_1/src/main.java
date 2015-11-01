

/**
 * Created by Admin on 05.10.15.
 */

public class main {

    public static void main(String[] args) {


        SetCollection Temp = new SetCollection();
        GetShow tmp = new GetShow();
        System.out.println("Podaj liczby w jednej lini po przecinku:");
        tmp.Insert();
        Temp.setList(tmp.Split());
        System.out.println("Najwieksza liczba mozliwa po zamianie miejsc: ");
        tmp.show(Temp.Sort());

    }
}

