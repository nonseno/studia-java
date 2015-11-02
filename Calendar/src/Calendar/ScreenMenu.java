package Calendar;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 24.10.15.
 */
public class ScreenMenu {
    private ArrayList<Category> Calendar;
   // private Scanner In;
    private Priority urgent;
    private Priority normal;
    private Priority low;


    public ScreenMenu()
    {
        Calendar= new ArrayList<Category>();
        //In= new Scanner(System.in);
        urgent = Priority.URGENT;
        normal = Priority.NORMAL;
        low = Priority.LOW;
    }

    public void clean(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");}

    public void open()
    {
        Scanner In= new Scanner(System.in);
        int choice=0;
        while(choice!=8) {
            System.out.println("Wybierz z menu: ");
            System.out.println("1) Dodaj kategorie");
            System.out.println("2) Dodaj zadanie");
            System.out.println("3) Wyswietl wszystkie kategorie");
            System.out.println("4) Wyswietl zadania z kategorii o zadanym priorytecie");
            System.out.println("5) Usun zadanie");
            System.out.println("6) Oznacz zadanie jako zrobione");
            System.out.println("7) Pokaz niedokonczone zadania");
            System.out.println("8) Koniec programu\n");
            System.out.println("Podaj numer: ");
            choice=In.nextInt();
            switch(choice)
            {
                case 1:
                    AddCategory();
                    break;
                case 2:
                    AddTask();
                    break;
                case 3:
                    ShowCategories();
                    break;
                case 4:
                    ShowCategoriesPriority();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public void AddCategory()
    {
        clean();
        String PrioTemp = new String();
        Scanner In= new Scanner(System.in);
        System.out.println("Podaj nazwe nowej kategori: ");
        String NameTemp=In.nextLine();
        System.out.println("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        PrioTemp=In.nextLine();
        PrioTemp=PrioTemp.toLowerCase();
        if(PrioTemp.matches(urgent.name().toLowerCase()))
        {
            Calendar.add(new Category(NameTemp,urgent));
        }
        else if(PrioTemp.matches(normal.name().toLowerCase()))
        {
            Calendar.add(new Category(NameTemp,normal));
        }
        else if(PrioTemp.matches(low.name().toLowerCase()))
        {
            Calendar.add(new Category(NameTemp,low));
        }
        else
        {
            System.out.println("Podano zla kategorie.");
        }
    }

    public void AddTask()
    {
        clean();
        Scanner In= new Scanner(System.in);
        System.out.println("Do ktorej kategori chcesz dodac zadanie? Podan numer: ");
        for(int i=0; i<Calendar.size(); i++)
        {
            System.out.println(1+i+") "+Calendar.get(i).Name);
        }
        int choice=In.nextInt();
        Calendar.get(choice-1).Add();
    }

    public void ShowCategories()
    {
        clean();
        System.out.println("Wszystkie kategorie:  \n");
        for(int i=0; i<Calendar.size(); i++)
        {
            System.out.println(1+i+") "+Calendar.get(i).Name);
        }
        System.out.println("\n\n");
    }

    public void ShowCategoriesPriority()
    {
        Scanner In= new Scanner(System.in);
        clean();
        System.out.println("Kategorie z ktorego priorytetu chcesz obejrzec (URGENT,NORMAL,LOW): ");
        String PrioTemp=In.nextLine();
        PrioTemp=PrioTemp.toLowerCase();
        clean();
        System.out.println("Oto wszystkie zadania przydzielone do danych kategori priorytetu "+PrioTemp+" :\n");
        for(int i=0; i<Calendar.size(); i++)
        {
            if(PrioTemp.matches(Calendar.get(i).Pro.name().toLowerCase()))
            {
                System.out.println("Kategoria: "+Calendar.get(i).Name+"\nZadania: ");
                for(int j=0; j<Calendar.get(i).Tasks.size(); j++)
                {
                    System.out.println(1+j+") "+Calendar.get(i).Tasks.get(j).Name);
                }

            }
        }
        System.out.println("\n\n");
    }

}
