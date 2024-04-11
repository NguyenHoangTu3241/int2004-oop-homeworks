import java.util.Scanner;

public class MergeSort {
    private static void merge(int a[], int aux[], int left, int middle, int right) {
        for(int h = left; h <= right; h++) {
            aux[h] = a[h];
        }
        int i = left, j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            if (aux[i] <= aux[j]) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            a[k] = aux[i];
            i++;
            k++;
        }
        while (j <= right) {
            a[k] = aux[j];
            j++;
            k++;
        }

    }
    private static void sort(int a[], int aux[], int left, int right) {
        if(left >= right) return;
        int middle = (left + right) / 2;
        sort(a, aux, left, middle);
        sort(a, aux, middle + 1, right);
        merge(a, aux, left, middle, right);
    }
    public static void mergesort(int a[], int left, int right) {
        int[] aux = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        sort(a, aux, left, right);
    }


}