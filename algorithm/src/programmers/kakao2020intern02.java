package programmers;

import java.util.ArrayList;

public class kakao2020intern02 {

	public static void main(String[] args){
		String expression= "50*2";
		long answer = 0;
		String temp = expression;
		String [] o = temp.replaceAll("[0-9]","").split(""); 
		String [] n = expression.replaceAll("[^0-9]"," ").split(" ");
			
		
		ArrayList<Long> numbers = new ArrayList<Long>();
		ArrayList<String> operations = new ArrayList<>();
		int a=0;
		for(a=0; a<o.length; a++) {
			operations.add(o[a]);
			numbers.add(Long.parseLong(n[a]));
		}
		numbers.add(Long.parseLong(n[a]));
		
		int [][] order = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}};
		String [] op = {"-","+","*"};
		for(int i=0; i<6; i++) {
			ArrayList<Long> num = (ArrayList<Long>) numbers.clone();
			ArrayList<String> exp= (ArrayList<String>) operations.clone();
			for(int j=0; j<3; j++) {
				String now = op[order[i][j]];
				int k=0; 
				while(k<exp.size()) {
					String s = exp.get(k);
					if(s.equals(now)){
						long cal;
						if(now.equals("-")) {
							cal = num.get(k)-num.get(k+1);
						}else if(now.equals("*")) {
							cal = num.get(k)*num.get(k+1);
						}else{
							cal = num.get(k)+num.get(k+1);
						}
						num.set(k, cal);
						num.remove(k+1);
						exp.remove(k);
					}else {
						k++;
					}
				}
			}
			answer = Math.max(answer, Math.abs(num.get(0)));
		}		
		
		System.out.println(answer);
	}
	

}
