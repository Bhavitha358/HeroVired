import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        // Read the length of the array
        int n = sc.nextInt();
        // Read the elements of the array
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        // Find the number of negative subarrays
        int count = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += arr[j];
                if (sum < 0){
                    count++;
                }
            }
        }
        // Print the result
        System.out.println(count);
        
        sc.close();
        
    }
}
