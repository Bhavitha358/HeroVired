import java.util.ArrayList;
import java.util.List;
public class MissingNumbers {
	
	public static List<Integer> missedNumbers (int arr[], int n) {
		List<Integer> temp = new ArrayList<>();
		int prevNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];
            
            // Check if there is a gap between consecutive numbers
            if (currentNum - prevNum > 1) {
                // Add missing numbers between the current number and the previous number
                for (int missingNum = prevNum + 1; missingNum < currentNum; missingNum++) {
                    temp.add(missingNum);
                }
            }
            prevNum = currentNum;
        }
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 5, 6, 8, 10, 11, 14};
		int n = arr.length;
		List<Integer> miss_num = missedNumbers(arr,n);
		System.out.println(miss_num);

	}

}
