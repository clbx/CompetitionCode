/*
Written at 2019 Dickinson Programming Competition

Clay Buxton
Kevin Carman
Jon Wiseman
*/

package ebay;

import java.util.ArrayList;
import java.util.Arrays;

//Etown
//Tome 118
//Tabs are just captial spaces
//13

import java.util.Scanner;

public class esea {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		String[] inputs = input.split(" ");
		
		
		int[] buyers = new int[Integer.parseInt(inputs[0])];
		int[] sellers = new int[Integer.parseInt(inputs[1])];
		
		String buyerInput = in.nextLine();
		String[] buyerList = buyerInput.split(" ");
		
		String sellerInput = in.nextLine();
		String[] sellerList = sellerInput.split(" ");
		
		for(int i = 0; i < buyerList.length; i++) {
			buyers[i] = Integer.parseInt(buyerList[i]);
		}
		
		for(int i = 0; i < sellerList.length; i++) {
			sellers[i] = Integer.parseInt(sellerList[i]);
		}
		
		Arrays.sort(buyers);
		Arrays.sort(sellers);
		
		int shortest = 0;
		if(buyers.length < sellers.length) {
			shortest = buyers.length;
		}
		else {
			shortest = sellers.length;
		}
		
		int profit = 0;
		
		for(int i = 1; i <= shortest; i++) {
			
			int buyprice = i*buyers[buyers.length - i];
			
			int sellprice = i*sellers[i-1];
			
			
			int temp = buyprice - sellprice;
			if(temp > profit) {
				profit = temp;
			}
		}
		
		System.out.println(profit);
		
		
	}
}
