package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1475 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String [] arr = s.split("");
		int length = s.length();
		int [] count = new int [10];
		for(int i=0; i<length; i++) {
			if(arr[i].equals("6")|| arr[i].equals("9")) {
				count[6]++;
			}else {
				count[Integer.parseInt(arr[i])]++;
			}
		}
		count[6]=count[6]/2+count[6]%2;
		int temp = 0;
		for(int i=0; i<10;i++) {
			if(temp<count[i]) {
				temp = count[i];
			}
		}
		System.out.println(temp);
	}

}
