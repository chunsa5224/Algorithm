package programmers;

import java.util.HashMap;
import java.util.Map;

public class kakao2020intern03 {
	public static void main (String[] args) {
		String [] gems = {"2","3","3","4","1","5","2"};
		kakao2020intern03 k = new kakao2020intern03(); 
		k.solution(gems);
	}
	public int [] solution(String[] gems) {
		Map<String,Integer> gemsMap = new HashMap<>();
		
		for(String g : gems) {
			gemsMap.put(g,1);
		}
		
		int total = gemsMap.size();
		int r= -1;
		int l=0;
		int start =0;
		int end =gems.length-1;
		gemsMap.clear();

		while(r>=-1 && r<gems.length && l>=0 && l<gems.length) {
			if(gemsMap.size()==total) {
				if(r-l< end-start) {
					start = l;
					end = r;
				}
				if(gemsMap.get(gems[l])==1) gemsMap.remove(gems[l]);
				else gemsMap.put(gems[l], gemsMap.get(gems[l])-1);
				l++;
			}else if(gemsMap.size()<total) {
				r++;
				if(r==gems.length) break;
				gemsMap.put(gems[r], gemsMap.getOrDefault(gems[r], 0)+1);
			}
		}
		int [] answer = {start+1, end+1};
		return answer;
	}

}
