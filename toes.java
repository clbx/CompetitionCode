//Etown
//Tome 118
//Tabs are just captial spaces
//13


package problem2;

import java.util.Scanner;

public class toes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
	    int[] output = new int[n];
		
		int total = 0;
		int power = 0;
		int k = 0;
		
		
		for(int i = 0; i < n; i++) {
			String current = in.nextLine();
			total = 0;
			power = 0;
			k = 0;
			for(int j = 0; j < current.length() ; j ++) {
				k = 0;
				char temp = current.charAt(current.length() - j -1);
				if(temp == 'M') {
					k = 0;
				}
				if(temp == 'L') {
					k = -1;
				}
				if(temp == 'R') {
					k = 1;
				}
				
				total += k*Math.pow(3, power);
				power++;
			}
			output[i] = total;
		}
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		
		
		
		
	}
}
