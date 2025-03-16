import java.util.Arrays;

public class App2 {
    public static void main(String[] args){

        int[] arr1 = {154, 53, 2, 13, 4, 100};
        int[] arr2 = {10, 5, 7, 2, 33, 98, 100};

        sortMetSelectie(arr1);
        sortMetSelectie(arr2);
        //afiseaza array urile
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.toString(mergeSort(arr1, arr2)));

    }

    public static void sortMetSelectie(int[] arr) {
        for (int i=0; i<arr.length - 1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j]<arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] mergeSort(int[] arr1, int[] arr2) {
        int n, m;
        n = arr1.length;
        m = arr2.length;
        int[] arr3 = new int[n+m];
        int i = 0, j = 0, k = 0;
        while (i<n && j<m) {
            if (arr1[i]<=arr2[j]) {
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < n){
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m){
            arr3[k] = arr2[j];
            j++;
            k++;
        }
        return arr3;
    }
}
