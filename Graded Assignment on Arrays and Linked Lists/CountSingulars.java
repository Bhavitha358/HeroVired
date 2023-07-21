import java.util.HashMap;
import java.util.Map;
public class CountSingulars {
	public static int countSingularSocks(int arrNum[]) {
		Map <Integer, Integer> sockCountMap = new HashMap<>();
		for (int sockId : arrNum) {
			sockCountMap.put(sockId, sockCountMap.getOrDefault(sockId, 0) +1);
		}
		
		int singularSocksCount = 0;
		
		for(int sockId : sockCountMap.keySet()) {
			int sockCount = sockCountMap.get(sockId);
			if (sockCount%2 != 0) {
				singularSocksCount++;
			}
		}
		return singularSocksCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int singularSocksCount = countSingularSocks(arrNum);
		System.out.println("Count of singular socks = " + singularSocksCount);

	}

}
