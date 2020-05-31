package codingTest;

import java.util.Arrays;

public class hyundaicard03 {

	public static void main(String[] args) {
		String[] registered_list= {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
		String new_id = "cow";
		while(Arrays.asList(registered_list).contains(new_id)) {
			int i=0;
			for(i=0; i<new_id.length();i++) {
				int idx = new_id.charAt(i);
				if(idx >= 48 && idx <= 57) {
					break;
				}
			}
			
			String s= new_id.substring(0,i);
			String n;
			if(i==new_id.length()) {
				n="0";
			}else {
				n =new_id.substring(i);
			}
			
			n = Integer.toString(Integer.parseInt(n)+1);
			new_id =s+n; 
		}
		System.out.println(new_id);
		
	}

}
