package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Worker _hlp = new Worker();
        MenuPrinter _ctr= new MenuPrinter();
        _hlp.AddFewCategoriesStacks();
        int choice=0;
        while(choice!=8) {
            choice=_ctr.ShowMenu();
            switch(choice)
            {
                case 1:
                    _hlp.AddCategory();
                    break;
                case 2:
                    _hlp.AddTask();
                    break;
                case 3:
                    _ctr.ShowCategories(_hlp);
                    break;
                case 4:
                    _ctr.ShowCategoriesPriority(_hlp);
                    break;
                case 5:
                    _hlp.DeleteTask();
                    break;
                case 6:
                    _hlp.MarkTask();
                    break;
                case 7:
                    _ctr.ShowUndoneTasks(_hlp);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

    }
}
