import java.util.Random;

public class randice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a random object to store random values
		Random randnum = new Random();
		//initialize two variables to store the values of the dice 
		int d1=0;
		int d2=0;
		
		//initialize an array to store the values 
		//create an upperbound value to store the highest runs
		int times=13;
		//create an array
		int val[]= new int [times];
		for (int i=0;i<times;i++) {
			val[i]=0;
		}
		
		//Given number of rolls 
		int noofrolls=36000000;
		//generating and storing random numbers in array
		for (int j=0;j<=noofrolls;j++) {
			d1=randnum.nextInt(6)+1;//increase to satisfy the upperbound value
			d2=randnum.nextInt(6)+1;
			val[d1+d2]++;
			
		}
		System.out.println("The frequency of sum for 36,000,000 rolls");
		System.out.println("\n");
		System.out.printf("Sum\tFrequency\tPercentage\n");
		
		//printing the array in matrice form 
		for (int k=2;k<times;k++) {
			int store=val[k];
			int perc=(store*100/noofrolls);
			System.out.printf("%d\t%d\t\t%d\n",k,store,perc);
		}
		
	}//end of main

}//end of class
