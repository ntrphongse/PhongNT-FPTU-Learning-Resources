/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.LinkedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class IntSorter {
    public static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    // Selection sort: O(n^2)
    // Get index of minimum value from first to last position in a[]
    public static int getMinIndex(int a[], int first, int last) {
        int minIndex = first;
        for (int i = first + 1; i <= last; i++) // O(n)
            if (a[minIndex] > a[i])
                minIndex = i;
        return minIndex;
    }
    
    public static void selectionSort(int a[], int n) { // O(n^2)
        int minIndex;
        for (int i = 0; i < n-1; i++) { // O(n)
            minIndex = getMinIndex(a, i, n-1);
            swap(a, minIndex, i);
        }
    }
    
    // Insertion sort: O(n^2) but no swap occurs
    public static void insertionSort(int a[], int n) {
        int i, j, tmp;
        for (i = 1; i < n; i++) { // O(n)
            tmp = a[i];
            j = i-1;
            while (j >= 0 && a[j] > tmp) { // O(n)
                a[j+1] = a[j];
                j--;
            }
            
            a[j+1] = tmp;
        }
    }
    
    // Bubble sort: O(n^2)
    public static void bubbleSort(int a[], int n) {
        int i, j;
        for (i = 0; i < n-1; i++) // O(n)
            for (j = 0; j < n-i-1; j++) // O(n)
                if (a[j] > a[j+1])
                    swap(a, j, j+1);
    }
    
    // Quick sort 1: O(nlogn)
    // Using the mid of array to be the pivote
    private static void quickSort1(int a[], int first, int last) {
        int mid = (first + last)/2;
        swap(a, first, mid);
        int lower = first + 1, upper = last;
        int pivote = a[first];
        while (lower <= upper) {
            while (lower <= upper && pivote > a[lower])
                lower++;
            while (lower <= upper && pivote < a[upper])
                upper--;
            if (lower < upper)
                swap(a, lower++, upper--);
            else
                lower++;
        }
        
        // Upper is the suitable position for the pivote
        // pivote must be put to the right position
        swap(a, upper, first);
        
        if (first < upper - 1)
            quickSort1(a, first, upper - 1);
        if (upper + 1 < last)
            quickSort1(a, upper + 1, last);
    }
    
    public static void quickSort1(int a[], int n) {
        quickSort1(a, 0, n - 1);
    }
    
    // Quick sort 2: O(nlogn)
    // The pivote is the median of a[first], a[last] and a[mid]
    // Get median of 3 integers
    public static int median(int a, int b, int c) {
        if ((a > b && a < c) || (a > c && a < b))
            return a;
        if ((b > a && b < c) || (b > c && b < c))
            return b;
        return c;
    }
    
    private static void quickSort2(int a[], int first, int last) {
        if (first >= last)
            return;
        int mid = (first + last)/2;
        int pivote = median(a[first], a[last], a[mid]);
        int lower = first;
        int upper = last;
        while (lower <= upper) {
            while (lower <= upper && pivote > a[lower])
                lower++;
            while (lower <= upper && pivote < a[upper])
                upper--;
            if (lower < upper)
                swap(a, lower++, upper--);
            else
                lower++;
        }
        quickSort2(a, first, upper);
        quickSort2(a, upper + 1, last);
    }
    
    public static void quickSort2(int a[], int n) {
        quickSort2(a, 0, n - 1);
    }
    
    // Merge Sort: O(nlogn)
    static int[] temp;
    
    @SuppressWarnings("empty-statement")
    private static void merge(int[] a, int first, int last) {
        int mid = (first + last)/2;
        int i = first;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last)
            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        while (i <= mid)
            temp[k++] = a[i++];
        while (j <= last)
            temp[k++] = a[j++];
        for (k = 0, i = first; i <= last; a[i++] = temp[k++]);
    }
    private static void mergeSort(int[] a, int first, int last) {
        int mid = (first + last)/2;
        if (first < mid)
            mergeSort(a, first, mid);
        if (mid + 1 < last)
            mergeSort(a, mid + 1, last);
        merge(a, first, last);
    }
    
    public static void mergeSort(int[] a, int n) {
        if (n < 2)
            return;
        temp = new int[n];
        mergeSort(a, 0, n - 1);
    }
    
    // Heap Sort: O(nlogn)
    public static void moveDown(int[] a, int first, int last) {
        // leftChild = 2*father + 1; rightChild = 2*father + 2
        int largest = 2*first + 1; // largest if the left child
        while (largest <= last) {
            if (largest < last && a[largest] < a[largest + 1])
                largest++;
            if (a[first] < a[largest]) {
                swap(a, first, largest);
                first = largest;
                largest = 2*first + 1;
            }
            else
                largest = last + 1;
        }
    }
    
    public static void heapSort(int a[], int n) {
        for (int i = n/2 - 1; i >= 0; --i)
            moveDown(a, i, n-1);
        for (int i = n - 1; i >= 1; --i) {
            swap(a, 0, i);
            moveDown(a, 0, i - 1);
        }
    }
    
    // Radix Sort
    public static final int RADIX = 10;
    public static int countDigits(int n) {
        int count = 0;
        while (n/10 != 0) {
            count++;
            n /= 10;
        }
        return count+1;
    }
    
    public static int maxAbsolute(int a[], int n) {
        int result = Integer.MAX_VALUE;
        for (int x: a) {
            if (x < 0)
                x = -x;
            if (result < x)
                result = x;
        }
        return result;
    }
    
    public static void radixSort(int a[], int n) {
        int longest = maxAbsolute(a, n);
        int digits = countDigits(longest);
        int d, j, k, factor;
        LinkedList<Integer>[] queues = new LinkedList[RADIX];
        for (d = 0; d < RADIX; d++)
            queues[d] = new LinkedList<>();
        for (d = 1, factor = 1; d <= digits; factor *= RADIX, d++) {
            // Move elements in array to suitable queues based on the dth digits
            for (j = 0; j < n; j++)
                queues[(a[j] / factor) % RADIX].addLast(a[j]);
            // Move values in queus to the array
            for (j = k = 0; j < RADIX; j++)
                while (!queues[j].isEmpty())
                    a[k++] = queues[j].removeFirst();
        }
    }
}
    

