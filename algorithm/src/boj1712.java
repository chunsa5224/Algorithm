
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1712 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int c = Integer.parseInt(arr[2]);
		
		long i =1;
		
		if(c-b<=0) {
			i=-1;
		}else {
			i = a/(c-b) +1; 
		}
		System.out.println(i);
		
	}

}
