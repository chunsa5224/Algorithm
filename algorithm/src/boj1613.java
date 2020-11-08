import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1613 {
//	Floyd Warshall Algorithm
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [][] map = new int [n+1][n+1];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = -1;
			map[b][a] = 1;
		}
		for(int l=1; l<=k; l++) {
			for(int i=1; i<=k; i++) {
				for(int j=1; j<=k; j++) {
					if(map[i][l]==0 || map[i][l]!= map[l][j]) continue;
					map[i][j]=map[i][l];
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a =Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(map[a][b]+"\n");
		}
		System.out.println(sb);
	}

}
