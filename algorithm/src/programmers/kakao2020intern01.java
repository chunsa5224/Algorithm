package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class kakao2020intern01 {
	
	static int [] dx= {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static int [][]phone;
	
	public static void main(String[] args) {
		int [] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		int idx=0;
		for(int i: numbers) {
			if(i==0) numbers[idx]= 11;
			idx++;
		}
		String hand = "right";
		String answer = "";
		phone = new int [6][5];
		for(int i=0; i<6; i++) {
			Arrays.fill(phone[i], -1);
		}
		for(int i=0; i<=8; i++) {
			phone[(i/3)+1][i%3+1] = i+1;
		}
		phone[4][2]=11;
		phone[4][3]=-2;
		phone[4][1]=-2;
		
		Finger right = new Finger(4,3,0);
		Finger left = new Finger(4,1,0);
		
		for(int n: numbers) {
			if(n==1 || n==4 || n==7) {
				left.x=(n-1)/3+1;
				left.y=(n-1)%3+1;
				answer +="L";
			}else if(n==3 || n==6 || n==9) {
				right.x=(n-1)/3+1;
				right.y=(n-1)%3+1;
				answer+="R";
			}else {
				int leftDist = find(left,n);
				int rightDist = find(right,n);
				if(leftDist>rightDist) {
					right.x=(n-1)/3+1;
					right.y=(n-1)%3+1;
					answer+="R";
				}else if(leftDist<rightDist){
					left.x=(n-1)/3+1;
					left.y=(n-1)%3+1;
					answer +="L";
				}else {
					if(hand.equals("right")) {
						right.x=(n-1)/3+1;
						right.y=(n-1)%3+1;
						answer+="R";
					}else {
						left.x=(n-1)/3+1;
						left.y=(n-1)%3+1;
						answer +="L";
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	static int find (Finger finger, int n) {
		Queue<Finger> q = new LinkedList<Finger>();
		q.add(finger);
		boolean visit[][] = new boolean[6][4];
		int dist =0;
		while(!q.isEmpty()) {
			Finger f = q.poll();
			visit[f.x][f.y]=true;
			for(int i=0; i<4; i++) {
				int xx= f.x+dx[i];
				int yy= f.y+dy[i];
				if(phone[xx][yy]!=-1 && !visit[xx][yy]) {
					visit[xx][yy]=true;
					if(phone[xx][yy]==n) {
						dist = f.dist+1;
						return dist;
					}else {
						q.add(new Finger(xx,yy,f.dist+1));
					}
				}
			}
		}
		return dist;
	}

}
class Finger{
	int x;
	int y;
	int dist;
	Finger(int x, int y, int dist){
		this.x=x;
		this.y=y;
		this.dist=dist;
	}
}
