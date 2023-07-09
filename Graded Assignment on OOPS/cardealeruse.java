public class cardealeruse extends cardealer{
	public static void main(String[] args) {
		cardealeruse cdu=new cardealeruse();
		String[] arr= new String[]{"Polo Trendline","Polo Highline","Virtus Trendline","Virtus Highline","Taigun Trendline","Taigun Highline","Taigun Topline"};
		long[] cost=new long[]{870000,1009000,1105000,1308000,1489000,1542000,1771000};
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " " + cost[i]);
        }
		cdu.getCarModel();
		for(int i=0;i<arr.length;i++)
	  {
			
			if(arr[i].equals(cdu.carmodel))
			{
				cdu.getCost(arr[i],cost[i]);
				
			}
		}
	}
}
