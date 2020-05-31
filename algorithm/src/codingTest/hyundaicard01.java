package codingTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class hyundaicard01 {

	public static void main(String[] args) throws ParseException {
		String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
		int n = purchase.length;
		int [] price = new int [n];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		for(int i=0; i<n; i++) {
			price[i] = Integer.parseInt(purchase[i].substring(11));
			purchase[i] = purchase[i].substring(0,10);
		}
		int bronze =0;
		int silver =0;
		int gold =0;
		int platinum =0;
		int dia =0;

		int answer [] = new int [365];
		int [] temp = new int [n];
		
		for(int i=0; i<n; i++) {
			long a= (sdf.parse(purchase[i]).getTime()-sdf.parse("2019/01/01").getTime())/(24*60*60*1000);
			
			answer[(int) a] = price[i];
			temp[i]=(int)a;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<30; j++) {
				answer[temp[i]+j]+=price[i];
			}
		}
		
		for(int i=0; i<365; i++) {
			int sum = answer[i];
			
			if(sum<10000) {
				bronze++;
			}else if(sum<20000 && sum >=10000) {
				silver++;
			}else if(sum<50000 && sum >=20000) {
				gold++;
			}else if(sum<100000 && sum >=50000) {
				platinum++;
			}else{
				dia++;
			}
			
		}
		System.out.println(bronze+" "+silver+ " " +gold +" "+platinum+" "+dia);
		
	}

}
