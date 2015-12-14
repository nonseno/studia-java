package Calendar;

/**
 * Created by Admin on 15.11.15.
 */
public class Handler {
    MenuPrinter MenuPrinter;
    String[] ArrayHandler ;
    Worker Worker;

    public Handler(Worker Worker)
    {
        MenuPrinter = new MenuPrinter();
        ArrayHandler = new String[2];
        this.Worker=Worker;
    }


    public Category HandleCategory() throws Exception {
        ArrayHandler[0]=MenuPrinter.QuestionString("Podaj nazwe nowej kategori: ");
        ArrayHandler[1]=MenuPrinter.QuestionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        ArrayHandler[1]=ArrayHandler[1].toLowerCase();
        if(ArrayHandler[1].matches(Priority.URGENT.name().toLowerCase()))
        {
            return new Category(ArrayHandler[0],Priority.URGENT);
        }
        else if(ArrayHandler[1].matches(Priority.NORMAL.name().toLowerCase()))
        {
            return new Category(ArrayHandler[0],Priority.NORMAL);
        }
        else if(ArrayHandler[1].matches(Priority.LOW.name().toLowerCase()))
        {
            return new Category(ArrayHandler[0],Priority.LOW);
        }
        else
        {
            throw new Exception("Podano zla kategorie");
        }
    }

    public String[] HandleTask() {
        ArrayHandler[0]=MenuPrinter.CategoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ", Worker);
        ArrayHandler[1]=MenuPrinter.QuestionString("Podaj nazwe zadania: ");
        return ArrayHandler;
    }

    public String[] HandleRemove() {
        ArrayHandler[0]=MenuPrinter.CategoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",Worker);
        ArrayHandler[1]=MenuPrinter.TaskAsk(ArrayHandler[0],"Ktore zadanie chcesz usunac? Podaj numer: ", Worker);
        return ArrayHandler;
    }

    public String[] HandleMark() throws Exception
    {
        ArrayHandler[0]=MenuPrinter.CategoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",Worker);
        Worker.CheckIfThereAreUndoneTasks(ArrayHandler[0]);
        ArrayHandler[1]=MenuPrinter.TaskAsk(ArrayHandler[0],"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",Worker);
        return ArrayHandler;
    }

}
