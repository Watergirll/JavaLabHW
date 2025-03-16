import java.util.Arrays;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        int n;
        //read n
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce n cuprins intre 0 si 5: ");
            n = sc.nextInt();
        }while (n<0 || n>5);

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            Scanner sc = new Scanner(System.in);
            arr[i] = sc.nextInt();
        }

        //apel metoda care inverseaza ordinea elementelor din array
        inverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void inverse(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
}