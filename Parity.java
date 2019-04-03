import java.util.Scanner;

public class Parity {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		int n = Integer.parseInt(console.nextLine());
		String[] output = new String[n];
		for(int i = 0; i < output.length; i++)
			output[i] = "";
		
		String number = "";
		int ones = 0;
		
		for(int i = 0; i < n; i ++) {
			number = console.nextLine();
			int bottom = 0;
			int top = 7;
			
			while(top <= number.length()) {
				String substring = number.substring(bottom, top);
				ones = 0;
				String parity = "";
				
				for(int j = 0; j < substring.length(); j++) 
					if(substring.charAt(j) == '1')
						ones++;
				
				if(ones % 2 == 0)
					parity = "1";
				else
					parity = "0";
				
				output[i] += parity;
				bottom += 7;
				top += 7;
			}
				
			
		}
		
		for(int i = 0; i < n; i++)
			System.out.println(output[i]);
		
	}
}
