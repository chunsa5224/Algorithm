package codingTest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class kakao02 {

	public static void main(String[] args) throws ScriptException {
		String expression ="50*6-3*2";
		
		String [] op = {"+","-","*"};
		int [][] order = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}}; 
		long max=0;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		for(int i=0; i<6; i++) {
			String result="";
			String [] arr1 = expression.split("\\"+op[order[i][0]]);
			for(int j=0; j<arr1.length;j++) {
				String [] arr2 = arr1[j].split("\\"+op[order[i][1]]);
				arr1[j]="";
				for(int k=0; k<arr2.length; k++) {
					arr2[k] = engine.eval(arr2[k])+"";
					arr1[j]+= arr2[k]+op[order[i][1]];
				}
				arr1[j]=arr1[j].substring(0,arr1[j].length()-1);
				arr1[j]=engine.eval(arr1[j])+"";
				
				result += arr1[j]+op[order[i][0]];
			}
			result=result.substring(0,result.length()-1);
			max = Math.max(max, Math.abs(Long.parseLong(engine.eval(result).toString())));
		}
		System.out.println(max);
		
		

	}

}
