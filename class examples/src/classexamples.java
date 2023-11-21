
public class classexamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = {{1,2,3},{1,2}};
		int[][] arr2 = {{1,33,3},{4},{9,2}};
		
		System.out.println("Val in r1 ");
		oparr(arr1);
		
		System.out.println("%nval in r2 %n");
		oparr(arr2);
	}

	public static void oparr(int[][] a) {
		for (int r=0;r<a.length;r++) {
			for (int c=0;c<a[r].length ; c++) {
				System.out.printf("%d  ",a[r][c]);
			System.out.println();
			}
		}
	}
}
