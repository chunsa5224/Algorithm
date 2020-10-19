
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj2839 {
=======
public class ex2839 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		int n = i;
		int result = 0;
		while(n>0) {
			if(n%5==0) {
				result = result + n/5;
				break;
			}else if(n%5==3) {
				result = result + n/5 + 1;
				break;
			}else if(n>5) {
				if(n-5==4||n-5==1) {
					result+=n/3;
					break;
				}else if(n==12) {
					result+=4;
					break;
				}
                n-=5;
				result++;
			}else {
				if(i%3==0) {
					result=i/3;
					break;
				}
				result = -1;
				break;
			}
		}
		System.out.println(result);
		
	}

}

