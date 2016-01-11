package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        MenuPrinter menuPrinter= new MenuPrinter();
        Handler handler = new Handler(worker);
        int choice=0;
        while(choice!=8) {
            choice=menuPrinter.ShowMenu();
            switch(choice)
            {
                case 1:
                    handler.HandleCategory();
                    break;
                case 2:
                    handler.HandleTask();
                    break;
                case 3:
                    menuPrinter.ShowCategories(worker);
                    break;
                case 4:
                    menuPrinter.ShowCategoriesPriority(worker);
                    break;
                case 5:
                    handler.HandleRemove();
                    break;
                case 6:
                    handler.HandleMark();
                    break;
                case 7:
                    menuPrinter.showUndoneTasks(worker);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

    }
}
