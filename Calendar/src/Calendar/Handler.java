package Calendar;

/**
 * Created by Admin on 15.11.15.
 */
public class Handler {
    MenuPrinter ctr= new MenuPrinter();
    String[] temp ;
    Worker work;

    public Handler(Worker work)
    {
        temp = new String[2];
        this.work=work;
    }


    public Category HandleCategory() throws Exception {
        temp[0]=ctr.QuestionString("Podaj nazwe nowej kategori: ");
        temp[1]=ctr.QuestionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        temp[1]=temp[1].toLowerCase();
        if(temp[1].matches(Priority.URGENT.name().toLowerCase()))
        {
            return new Category(temp[0],Priority.URGENT);
        }
        else if(temp[1].matches(Priority.NORMAL.name().toLowerCase()))
        {
            return new Category(temp[0],Priority.NORMAL);
        }
        else if(temp[1].matches(Priority.LOW.name().toLowerCase()))
        {
            return new Category(temp[0],Priority.LOW);
        }
        else
        {
            throw new Exception("Podano zla kategorie");
        }
    }

    public String[] HandleTask() {
        temp[0]=ctr.CategoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ", work);
        temp[1]=ctr.QuestionString("Podaj nazwe zadania: ");
        return temp;
    }

    public String[] HandleRemove() {
        temp[0]=ctr.CategoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",work);
        temp[1]=ctr.TaskAsk(temp[0],"Ktore zadanie chcesz usunac? Podaj numer: ", work);
        return temp;
    }

    public String[] HandleMark() throws Exception
    {
        temp[0]=ctr.CategoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",work);
        work.CheckIfTask(temp[0]);
        temp[1]=ctr.TaskAsk(temp[0],"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",work);
        return temp;
    }





}
