package zad;

import zad.PageReader;

import java.util.Scanner;
/**
 * Created by Admin on 08.10.15.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Podaj nazwe pliku w ktorym chcesz policzyc linie: ");
        Scanner wejscie = new Scanner(System.in);
        String plik = new String();
        plik=wejscie.nextLine();
        PageReader liczLinie = new PageReader();
        liczLinie.otworz(plik);
        System.out.println("Chcesz policzyc: \n");
        System.out.println("(1)- wszystkie linie w pliku");
        System.out.println("(2)- chce pominac linie z nawiasami");
        System.out.println("(3)- chce pominac linie puste");
        System.out.println("(4)- chce pominac linie z nawiasami i puste\n");
        System.out.println("Podaj cyfre: ");
        int wybor=wejscie.nextInt();
        switch(wybor) {
            case 1:
                System.out.println("Liczba wszystkich lini wynosi: "+ liczLinie.wczytaj());
                break;
            case 2:
                System.out.println("Liczba lini bez nawiasow wynosi: "+ liczLinie.wczytajNawiasy());
                break;
            case 3:
                System.out.println("Liczba lini bez pustych zdan wynosi: " + liczLinie.wczytajPuste());
                break;
            case 4:
                System.out.println("Liczba lini bez nawiasow i pustych zdan wynosi: " + liczLinie.wczytajNawiasyPuste());
                break;
            default:
                System.out.println("Podano zla liczbe.");
                break;
        }
        liczLinie.zamknij();
    }
}
