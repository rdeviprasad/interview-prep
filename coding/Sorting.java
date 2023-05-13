import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sorting {
    public static void main(String[] args) {
        try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768); 
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 32768)
        ) {
            int n = Integer.parseInt(reader.readLine());
            
            // read an array of integers
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            writer.write("Original Array: ");
            writer.newLine();
            printArray(arr, writer);
            
            int[] ssArray = Arrays.copyOf(arr, n);
            selectionSort(ssArray, n);
            writer.write("Selection Sort: ");
            writer.newLine();
            printArray(ssArray, writer);

            int[] bsArray = Arrays.copyOf(arr, n);
            bubbleSort(bsArray, n);
            writer.write("Bubble Sort: ");
            writer.newLine();
            printArray(bsArray, writer);

            int[] isArray = Arrays.copyOf(arr, n);
            insertionSort(isArray, n);
            writer.write("Insertion Sort: ");
            writer.newLine();
            printArray(isArray, writer);

            int[] msArray = Arrays.copyOf(arr, n);
            mergeSort(msArray, n);
            writer.write("Merge Sort: ");
            writer.newLine();
            printArray(msArray, writer);

            int[] qsArray = Arrays.copyOf(arr, n);
            quickSort(qsArray, n);
            writer.write("Quick Sort: ");
            writer.newLine();
            printArray(qsArray, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if(low < high) {
            int pivot = getPivot(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    private static int getPivot(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low;
        int j = high;
        while (i < j) {
            while(a[i] <= pivot && i <= high - 1) {
                i++;
            }
            while(a[j] > pivot && j >= low + 1) {
                j--;
            }
            if(i < j) swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    private static void mergeSort(int[] a, int n) {
        mergeSort(a, 0, n - 1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temporaryList = new ArrayList<>();
        while(left <= mid && right <= high) {
            if(a[left] <= a[right]) {
                temporaryList.add(a[left++]);
            } else {
                temporaryList.add(a[right++]);
            }
        }

        while(left <= mid) {
            temporaryList.add(a[left++]);
        }

        while(right <= high) {
            temporaryList.add(a[right++]);
        }

        for(int i = low; i <= high; i++) {
            a[i] = temporaryList.get(i - low);
        }
    }

    private static void insertionSort(int[] a, int n) {
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && a[j - 1] > a[j]) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

    private static void bubbleSort(int[] a, int n) {
        for (int i = n - 1; i >= 1; i--) {
            boolean swapped = false;
            for(int j = 0;  j <= i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    private static void selectionSort(int[] a, int n) {
        for(int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i; j < n; j++) {
                if(a[j] <= a[mini]) {
                    mini = j;
                }
            }
            // System.out.println("swap between : " + i + " and " + mini);
            swap(a, i, mini);
        }
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void printArray(int[] arr, BufferedWriter writer) throws IOException {
        for(int x : arr) {
            writer.write(x + " ");
        }
        writer.newLine();
    }
}