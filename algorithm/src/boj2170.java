import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj2170 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int [][] line = new int [n][2];
		int answer =0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i][0] = Math.min(a, b);
			line[i][1] = Math.max(a, b);
		}
		Arrays.sort(line, (o1, o2)->{
			if(o1[0]==o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int start = line[0][0]; 
		int end = line[0][1];
		for(int i=1; i<n; i++) {
			if(line[i][0]<=end && line[i][1]>end) {
				end = line[i][1];
			}else if(line[i][0]>end) {
				answer += end-start;
				start = line[i][0];
				end = line[i][1];
			}
		}
		answer += end-start;
		System.out.println(answer);
		
		
	}

}
