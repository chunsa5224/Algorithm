import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] num = new int [n];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		int left=0;
		int right =n-1;
		for(; left<right; left+=2) {
			if(num[left]<1 && num[left+1]<1) {
				answer += num[left]*num[left+1];
			}else {
				break;
			}
		}
		for(;right>left;right-=2) {
			if(num[right]>1 && num[right-1]>1) {
				answer += num[right] * num[right-1];
			}else {
				break;
			}
		}
		for(; right >= left; right--) {
			answer += num[right];
		}
		
		System.out.println(answer);

	}

}
