public class GenericMethodDemo {

    // Generic method to print any array
    public static <T> void printArray(T[] array) {
        System.out.print("[ ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }

    // Generic method to find maximum of two values
    public static <T extends Comparable<T>> T findMax(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }

    public static void main(String[] args) {

        // printArray with different types
        Integer[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"Java", "Python", "C++"};
        Double[] dblArr = {1.1, 2.2, 3.3};

        System.out.print("Integer Array: " );
         printArray(intArr);

        System.out.print("String Array:  ");
        printArray(strArr);

        System.out.print("Double Array:  ");
        printArray(dblArr);

        System.out.println("---");

        // findMax with different types
        System.out.println("Max(10, 20): "     + findMax(10, 20));
        System.out.println("Max(A, Z): "       + findMax('A', 'Z'));
        System.out.println("Max(Java, Python): "+ findMax("Java", "Python"));
    }
}