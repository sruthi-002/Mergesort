package com.company;
import java.util.Scanner;
class Merge {
    void merge(int a[], int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];
        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];
        i = 0;
        j = 0;
        k = beg;
        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }
    void mergeSort(int a[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }
    void printArray(int a[],int n)
    {
        int i;
        for(i=0;i<n;i++)
            System.out.println(a[i]);
    }
}
    class Main {
        public static void main(String args[]) {
            int i ;
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int []a = new int[n];
            for(i=0;i<n;i++)
                a[i]=in.nextInt();
            Merge m1 = new Merge();
            m1.mergeSort(a, 0, n - 1);
            m1.printArray(a, n);
        }
    }
