package generics;

import java.util.ArrayList;

public class customarraylist {
    public static void main(String[] args) {
        ArrayList List = new ArrayList();
        List.add(45);
        List.remove(0);
        List.get(0);
        List.set(1,612415089);
        List.size();
        List.isEmpty();

        // generics provide parameterized type to arraylist
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(65);    
        //List(ubwed);    //will throw error
    
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("Kedar");

        }
}
