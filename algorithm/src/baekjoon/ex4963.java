package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex4963 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String wh = "";
		ArrayList<Integer> result =new ArrayList<>(); 
		do{
			int count=0;
			wh= br.readLine();
			int width = Integer.parseInt(wh.split(" ")[0]);
			int height = Integer.parseInt(wh.split(" ")[1]);
			
			int [][] graph = new int[height][width];
			
			for(int i=0;i<height;i++) {
				String [] temp = br.readLine().split(" ");
				for(int w=0; w<width; w++) {
					graph[i][w] = Integer.parseInt(temp[w]);
				}
			}
			
			for(int h=0; h<height; h++) {
				for(int w=0; w<width; w++) {
					if(graph[h][w]==1) {
						if(h==0 && w==0 ) {
							count++;
						}else {
							if(h>0 && w>0) {
								if(h==height-1) {
									if(graph[h-1][w]==0 && graph[h-1][w-1]==0&& graph[h][w-1]==0){
										count++;
									}
								}else {
									if(graph[h-1][w]==0 && graph[h-1][w-1]==0&& graph[h][w-1]==0 && graph[h+1][w-1]==0 && graph[h+1][w]==0){
										count++;
									}
								}
							}else if(h==0) {
								if(height!=1) {
									if(graph[0][w-1]==0 && graph[1][w-1]==0 && graph[1][w]==0){
										count++;
									}
								}else {
									if(graph[0][w-1]==0){
										count++;
									}
								}
							}else if(w==0) {
								if(graph[h-1][0]==0){
									count++; 
								}
							}
						}
					}
				}
			}
			result.add(count);
		}while(!wh.equals("0 0"));
		
		if(result.size()!=1) {
			for(int i=0; i<result.size()-1;i++){
				System.out.println(result.get(i));
			}
		}
	}

}
