import java.util.Scanner;
public class cardealer {
			public String carmodel;
			public String insurance;
			public String add_accessories;
			public String discount;
			public long RTO=113990;
			public long TCSCharges=11000;
			public long discount_amt=0;
			public void getCarModel()
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Select car model: ");
				carmodel=sc.nextLine();
				System.out.println("Do you need insurance");
				insurance=sc.nextLine();
				System.out.println("Do you need Additional Accessories: ");
				add_accessories=sc.nextLine();
				System.out.println("Dealer discount: ");
				discount=sc.nextLine();
				sc.close();
			}
				
			public void getCost(String carName,long cost)
			{
				long total=cost+RTO+TCSCharges;
				int insurance_amt=0;
				int add_accessories_amt=0;
				if (insurance.equals("yes") || insurance.equals("YES")){
					insurance_amt=47300;
					total+=insurance_amt;
				}
				if (add_accessories.equals("yes") || insurance.equals("YES")) {
					add_accessories_amt=15000;
					total+=add_accessories_amt;
				}
				if (discount.endsWith("%")) {
					discount=discount.replace("%","");
					discount_amt=Integer.valueOf(discount)*cost/100;
				}
				else
					discount_amt=Integer.valueOf(discount);
				if(discount_amt>30000) {
					System.out.println("Maximum discount should not cross 30000!");
				}
				if(!insurance.equalsIgnoreCase("yes") && !add_accessories.equalsIgnoreCase("yes") && discount_amt > 0) {
					System.out.println("Any one of the additional features have to be added!");
					discount_amt=0;
				}
				if(insurance.equalsIgnoreCase("yes") || add_accessories.equalsIgnoreCase("yes") && discount_amt <= 30000) {
					total-=discount_amt;
				}
				System.out.println();
				System.out.println("Total cost "+total+"("+carmodel+" "+cost+" + "+RTO+"(RTO) + "+insurance_amt+"(Insurance) + "+TCSCharges+"(TCS) + "+add_accessories_amt+"(Additional Accessories) - "+discount_amt+"(Dealer discount))");
		
			}
	}
