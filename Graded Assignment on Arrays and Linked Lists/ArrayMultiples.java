public class ArrayMultiples {
	public static int arrayProduct(int arr[], int n) {
		int product = 1;
		for (int i = 0; i<n; i++) {
			product = product * arr[i];
		}
		return product;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 3, 4, 2, 0, 8};
		int n = arr.length;
		int cum_product = 0;
		try {
			cum_product = arrayProduct(arr, n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cum_product);

	}

}
