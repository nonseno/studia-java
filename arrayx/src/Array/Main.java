package Array;


/**
 * Created by Admin on 22.10.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        MyArray<Integer> arr = new MyArray<Integer>();
        MyArray<String> arr2 = new MyArray<String>();
        arr.add(10);
        arr.add(15);
        arr.add(151);
        arr.add(5412);
        arr.remove();


        arr2.add("To JEST");
        arr2.add("napis !");
        System.out.println(arr.get(2));
        System.out.println(arr.toString());
        System.out.println(arr2.toString());

        arr2.set(1,"cos");
        System.out.println(arr2.toString());
        arr.clear();
      //  arr2.clear();
        System.out.println(arr.isEmpty());
        System.out.println(arr2.isEmpty());

    }
}
