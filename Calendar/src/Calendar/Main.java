package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Worker _wrk = new Worker();
        MenuPrinter _prt= new MenuPrinter();
        Handler _hand = new Handler(_wrk);
        int choice=0;
        while(choice!=8) {
            choice=_prt.ShowMenu();
            switch(choice)
            {
                case 1:
                    _wrk.AddCategory(_hand.HandleCategory());
                    break;
                case 2:
                    _wrk.AddTask(_hand.HandleTask());
                    break;
                case 3:
                    _prt.ShowCategories(_wrk);
                    break;
                case 4:
                    _prt.ShowCategoriesPriority(_wrk);
                    break;
                case 5:
                    _wrk.RemoveTask(_hand.HandleRemove());
                    break;
                case 6:
                    _wrk.MarkTask(_hand.HandleMark());
                    break;
                case 7:
                    _prt.ShowUndoneTasks(_wrk);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

    }
}
