import java.util.Random;

/**
 *
 * @author ThyKhueLy  
 */
public class RockNRollah {
       
    public static void main(String[] args) {
    	// Create a Random object
    	Random randomNumbers = new Random(); 
    	
    	// Initialize a couple of variables to hold the values of the two dice
    	int dice1; // value on the first dice
    	int dice2; // value on the second dice
    	
    	// Initialize the array that will hold the results
    	int frequency = 13; // frequencies of sums

    	int total [] = new int [ frequency ]; 
    	for ( int index = 0; index < frequency; index ++)
    		total[index] = 0;
    	
    	/* Hypothetical questions: (no, I don't want answers)
    	 *   How many different sum values do we need to account for?
    	 *   How big does the array need to be?
    	 *   Why might you make it (slightly) larger? (Note: my answer does not use an unnecessarily large array, 
    	 *   and I'm not encouraging you to; just giving you something to think about) 
    	 */
    	
    	int rolls = 36000000; // number of rolling times
    	// counts for 36,000,000 rolls of two dices
    	for ( int t = 0; t <= rolls; t++ ) {
    		dice1 = randomNumbers.nextInt(6) + 1; 
    		dice2 = randomNumbers.nextInt(6) + 1;
    		total[dice1 + dice2]++;
		} // end for loop

    	// Display the frequencies
        System.out.println("Results after " + rolls + " rolls");
        System.out.println("-------------------------");
        System.out.println("Value\tFrequency");
        
        // Loop, displaying the rows for the body of the table, each on its own line.
        //  The required format for each row is to display the sum, followed by a tab, 
        //  followed by the number of times that sum came up. Do not include any additional formatting
        for (int sum = 0; sum < frequency; sum++ )
        	System.out.printf("%d\t%d\n" , sum, total[sum]);
        
    } // end main method
    
} // end RockNRollah class