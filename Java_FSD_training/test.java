public class test{
public static void main(String[] args)  {
		try {
        	System.out.println("Open the files");
        	int n = args.length;
        	System.out.println(n);
        	int a = 45/n;
        	System.out.println(a);
        	int b[] = {10,20,30};
        	b[50]= 90;
        	
        }
		catch (ArithmeticException ae) {
			System.out.println(ae);
			System.out.println("Please pass the number in the program");
		}
		catch (ArrayIndexOutOfBoundsException aie) {
			aie.printStackTrace();
			System.out.println("Please enter the index within the range");
		}
		finally {
			System.out.println("Close the files");
		}
     }
    }