
public class studpoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] res = {0,0,0,0,0,2,6,3,622,5,2,1,5,2,52,8,43,9};
		int[] freq = new int[6];

		for (int i=0; i < res.length; i++){
			try{
				++freq [res[i]];      }
			catch(ArrayIndexOutOfBoundsException e){
			        System.out.println(e);
			        System.out.printf("Responses [%d]= %d%n%n", i,res[i]);
			}
		System.out.printf("%s%10s%n","Rating","Frequency");
		for (int rating=1;rating < freq.length;rating++) {
			System.out.printf("%6d%10d%n",rating,freq[rating]);}
			 
	}

}}
