import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;


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
            int[] ssArray = Arrays.copyOf(arr, n);

            selectionSort(ssArray, n);
            writer.write("Selection Sort:");
            writer.newLine();
            printArray(ssArray, writer);
            
        } catch (IOException e) {
            e.printStackTrace();
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