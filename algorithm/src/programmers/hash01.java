package programmers;

import java.util.HashMap;

public class hash01 {

	public static String main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String answer ="";
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		
		for(String part : participant) {
			hm.put(part, hm.getOrDefault(part, 0)+1);
		}
		for(String comp : completion) {
			hm.put(comp, hm.get(comp)-1);
		}
		for(String part : participant) {
			if(hm.get(part)!=0) {
				answer = part;
			}
		}
		
		return answer;
		
	}

}
