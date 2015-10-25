package zad;

import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Admin on 08.10.15.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        String file="tekst.txt";
        Scanner wejscie = new Scanner(System.in);
       PageReader countLines = new PageReader();
        countLines.Open(file);
        countLines.read();
        System.out.println("Chcesz policzyc: \n");
        System.out.println("(1)- wszystkie linie w pliku");
        System.out.println("(2)- chce pominac linie z nawiasami");
        System.out.println("(3)- chce pominac linie puste");
        System.out.println("(4)- chce pominac linie z nawiasami i puste\n");
        System.out.println("Podaj cyfre: ");
        int choice=wejscie.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Liczba wszystkich lini wynosi: "+ countLines.getLines());
                break;
            case 2:
                System.out.println("Liczba lini bez nawiasow wynosi: "+ countLines.getBrackets());
                break;
            case 3:
                System.out.println("Liczba lini bez pustych zdan wynosi: " + countLines.getEmptyLines());
                break;
            case 4:
                System.out.println("Liczba lini bez nawiasow i pustych zdan wynosi: " + countLines.getEmptyBrackets());
                break;
            default:
                System.out.println("Podano zla liczbe.");
                break;
        }
        countLines.close();
    }
}
