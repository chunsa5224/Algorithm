import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15683 {
	static int N, M, ans;
	static int [][] map;
	//static boolean [][] visit;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static ArrayList<int []> list = new ArrayList<int []>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer (br.readLine()," ");
			for( int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) {
					list.add(new int [] {i,j});
				}
			}
		}
		
		int ans=0;
		
		System.out.println(ans);
		
	}

	static void monitor(int index, boolean [][] visit) {
		
		if(index == list.size()) {
			check();
		}else {
			int[] pos = list.get(index);
			int x= pos[0];
			int y = pos[1];
			int [] d = null;
			int [] temp=new int [4];
			int cctv = map[x][y];
			for(int i=0; i<4; i++) {
				int xx= x+dx[i];
				int yy= y+dx[i];
				while(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy]!=6) {
					if(map[xx][yy]==0 && !visit[xx][yy]) temp[i]++;
					xx= xx + dx[i];
					yy= yy + dy[i];
				}
			}
			int a =0;
			if(cctv==1) {
				int b=0;
				for(int i=0; i<4; i++) {
					if(a<temp[i]) {
						a = temp[i];
						b = i;
					}
				}
				d= new int [] {b};
			}else if(cctv==2) {
				if(temp[1]+temp[3]<temp[0]+temp[2]) {
					d = new int [] {0,2};
				}else {
					d = new int [] {1,3};
				}
			}else if(cctv==3) {
				int [] temp2 = new int [4];
				int b =0;
				temp2[0]= temp[0]+temp[1]; 
				temp2[1]= temp[1]+temp[2];
				temp2[2]= temp[2]+temp[3];
				temp2[3]= temp[3]+temp[0];
				
				for(int i=0; i<4; i++) {
					if(a<temp2[i]) {
						a = temp2[i];
						b =i;
					}
				}
				d = new int [] {b, (b+1)%4};
			}
			else if(cctv==4) {
				int b=0;
				for(int i=0; i<4; i++) {
					if(a>temp[i]) {
						a=temp[i];
						b=i;
					}
				}
				d = new int [3];
				int idx=0;
				for(int i=0; i<4; i++) {
					if(i!=b) {
						d[idx] = i; 
						idx++; 
					}
				}
			}else if(cctv==5){
				d = new int [] {0,1,2,3};
			}
			if(d!=null) {
				for(int i=0; i<d.length;i++) {
					int xx= x+dx[d[i]];
					int yy = y+ dy[d[i]];
					while(xx>=0 && xx<N && yy>=0 && yy<M && map[xx][yy]!=6) {
						if(map[xx][yy]==0 && !visit[xx][yy]) visit[xx][yy]=true;
						xx= xx + dx[d[i]];
						yy= yy + dy[d[i]];
					}
				}
			}
			monitor(index+1, visit);
			
		}
		
	}
	static void check() {
		int temp=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) temp++;
			}
		}
		ans = Math.max(ans, temp);
	}

}
