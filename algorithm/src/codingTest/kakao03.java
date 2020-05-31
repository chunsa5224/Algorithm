package codingTest;

import java.util.HashMap;

public class kakao03 {

	public static void main(String[] args) {

		String[] gems= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] best = new int [gems.length+1];
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		HashMap<String, Integer> temp = new HashMap<String, Integer>();
		
		for(int i=0; i<gems.length; i++) {
			hm.put(gems[i], 0);
			temp.put(gems[i], 0);
		}
		
		for(int i=0; i<gems.length; i++) {
			for(int j=i; j<gems.length; j++) {
				hm.put(gems[j], hm.get(gems[j])+1);
				if(hm.containsValue(0)==false) {
					best[i+1]=j+1;
					break;
				}
			}
			hm.clear();
			hm = (HashMap<String, Integer>) temp.clone();
		}
		
		int min=gems.length;
		int start =0;
		int end =0;
		for(int i=1; i<best.length; i++) {
			 if(min>best[i]-i && best[i]!=0) {
				 start =i;
				 end = best[i];
				 min = best[i]-i;
			 }
			 
		}
		int answer [] = {start,end};
		System.out.println(start + "," +end);
	}

}
