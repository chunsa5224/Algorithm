import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {
	static int N, max,min;
	static int [] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		num = new int [N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		int plus =Integer.parseInt(st.nextToken());
		int minus =Integer.parseInt(st.nextToken());
		int multi =Integer.parseInt(st.nextToken());
		int divi=Integer.parseInt(st.nextToken());

		max = -1000000000;
		min = 1000000000;
		cal(0,num[0],plus,minus,multi,divi);
		System.out.println(max);
		System.out.println(min);
		
		
	}
	static void cal(int idx, int ans, int plus, int minus, int multi, int divi) {
		if(idx==N-1) {
//			System.out.println("중간 점검 : " + ans);
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}
		else {
			if(plus!=0) {
//				System.out.println("0 "+idx +", "+ ans);
				int temp = ans + num[idx+1];
				cal(idx+1,temp,plus-1,minus,multi,divi);
			}
			if(minus!=0) {
//				System.out.println("1 "+idx+", "+ ans);
				int temp = ans - num[idx+1];
				cal(idx+1,temp,plus,minus-1,multi,divi);
			}
			
			if(multi!=0) {
//				System.out.println("2 "+idx+", "+ ans);
				int temp = ans * num[idx+1];
				cal(idx+1,temp,plus,minus,multi-1,divi);
			}
			if(divi!=0) {
//				System.out.println("3 "+idx+", "+ ans);
				int temp = ans / num[idx+1];
				cal(idx+1,temp,plus,minus,multi,divi-1);
			}
		}
	}

}
