package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lockAndKey {
	static int N,M,size;
    static int [][] map;
    static int [][] kmap;
    static Queue <int []> q = new LinkedList<>();
	public static void main(String[] args) {
		int [][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int [][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		boolean answer = solution(key,lock);
		System.out.println(answer);
	}
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = lock.length;
        M = key.length;
        map = new int [N+2*M-2][N+2*M-2];
        kmap = key;
        for(int i=0; i<N+2*M-2; i++) {
        	Arrays.fill(map[i], -1);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[M+i-1][M+j-1]=lock[i][j];
                if(lock[i][j]==0) size++;
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                if(key[i][j]==1) {
                    q.add(new int [] {i,j});
                }
            }
        }
        for(int i=0; i<N+M-1; i++){
            for(int j=0;j<N+M-1; j++){
                for(int k=0; k<4; k++){
                    clockwise();
                    if(find(i,j)) return true;
                }
            }
        }
        return answer;
    }
    static boolean find(int x, int y){
        int count=0;
        while(!q.isEmpty()){
            int [] idx = q.poll();
            if(map[x+idx[0]][y+idx[1]]==0) {
            	count++;
            }else if(map[x+idx[0]][y+idx[1]]==1) {
            	return false;
            }
        }
        if(count >= size) return true;
        else return false; 
    }
    static void clockwise(){
        int [][] temp = new int [M][M];
        q.clear();
        for(int i=0; i<M; i++) {
        	for(int j=0; j<M; j++) {
        		temp[i][j]=kmap[i][j];
        	}
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                kmap[j][M-i-1]= temp[i][j];
                if(kmap[j][M-i-1]==1) {
                	q.add(new int[]{j, M-i-1});
                }
            }
        }
    }


}
