/*
*
* This file is called Asscheeks because that was the state of mind we were in when we submitted
* this problem 8 times with 20 minutes left on the clock
*
* i hope someone enjoys this steaming pile of garbage
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class lost {
	
	static ArrayList<String> list = new ArrayList<String>();
	static String output = "";
	static ArrayList<String> outputTemp = new ArrayList<String>();
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);		
		String temp = "";
		int lineCount = 0;
		
		while((!temp.equals("***")) && (lineCount < 100)){
			temp = in.nextLine();
			//System.out.println(temp.length());
			if(temp.length() > 81)
				temp = temp.substring(0, 80);
			
			//System.out.println(temp);
			
			lineCount++;
			
			char ch = ' ';
			String wordtemp = "";

			
			for(int i = 0; i < temp.length(); i++){
				
				ch = temp.charAt(i);
				
				
				if(Character.isLetter(ch)){
					ch = Character.toLowerCase(ch);
					wordtemp += ch;
					//System.out.println(wordtemp);
				}
				if(ch == ' '){
					if(!list.contains(wordtemp)){
						list.add(wordtemp);
					}
					wordtemp = "";
				}
				
			}
			if(!list.contains(wordtemp)){
				list.add(wordtemp);
			}
			
			
			
		}
		//LIST ASSEMBLED
		ArrayList<String> amen = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++){
			String word = list.get(i);
			output = word + ":";
			
			delete(word);			
			insert(word);
			replace(word);
			transpose(word);

			//System.out.println(outputTemp.toString());
			
			outputTemp = sort(outputTemp);
			for(int p = 0; p < outputTemp.size(); p++){
				output += " " + outputTemp.get(p);
			}
				
			char last = output.charAt(output.length()-1);
			if(last != ':'){
				amen.add(output);
			}
			
			
			
			while(!outputTemp.isEmpty()){
				outputTemp.remove(outputTemp.size()-1);
			}
		}
		
		amen = sort(amen);
		//System.out.println(amen.toString());
		
		
		
		if(amen.isEmpty()){
			System.out.println("***");
		}
		else{
			for(int i = 0; i < amen.size(); i++){
				System.out.println(amen.get(i));
			}
		}
		//System.out.println(outputList.toString());
//		char last = output.charAt(output.length()-1);
//		if(last != ':'){
//			outputList.add(output);
//		}
		//Print alphabetically
		
	
		
		
	}
	
	
	
	static void delete(String word){
		if(word.length() > 1){
			for(int i = 0; i < list.size(); i++){
				String compareword = list.get(i);
				
				if(compareword.equals(word)){}
				
				else if(word.length()-1 == compareword.length()){
					for(int j = 0; j < word.length(); j++){
						String temp = word.substring(0,j) + word.substring(j+1, word.length());
						
						if(temp.equals(compareword)){
							if(!outputTemp.contains(compareword)){
								//System.out.println(compareword);
								outputTemp.add(compareword);
							}
						}
					}
				}
			}
		}
	}
	
	static void insert(String word){
		if(word.length() > 0){
			for(int i = 0; i < list.size(); i++){
				String compareword = list.get(i); ArrayList<String> list = new ArrayList<String>();
				
				if(compareword.equals(word)){}
				
				else if(word.length()+1 == compareword.length()){
					for(int j = 0; j < word.length()+1; j++){
						for(int k = 0; k < compareword.length(); k++){
							String temp = word.substring(0,j) + compareword.charAt(k) + word.substring(j, word.length());
							///System.out.println(temp);
							if(temp.equals(compareword)){
								if(!outputTemp.contains(compareword)){
									//System.out.println(compareword);
									outputTemp.add(compareword);
								}
							}
						}
					}
				}	
			}
		}
	}
	
	static void replace(String word){
		if(word.length() > 0){
			for(int i = 0; i < list.size(); i++){
				String compareword = list.get(i);
				
				if(compareword.equals(word)){}
				
				else if(word.length() == compareword.length()){
					for(int j = 0; j < word.length(); j++){
						for(int k = 0; k < compareword.length(); k++){
							String temp = word.substring(0,j) + compareword.charAt(k) + word.substring(j+1, word.length());
							if(temp.equals(compareword)){
								if(!outputTemp.contains(compareword)){
									//System.out.println(compareword);
									outputTemp.add(compareword);
								}
							}
						}
					}
				}	
			}
		}
	}
	
	static void transpose(String word){
		for(int i = 0; i < list.size(); i++){
			String compareword = list.get(i);
			
			if(compareword.equals(word) || word.length() < 2){}
			
			else if(word.length() == compareword.length()){
				for(int j = 0; j < word.length()-1; j++){
					String temp = word.substring(0,j) + word.charAt(j+1) + word.charAt(j) + word.substring(j+2, word.length());
					if(temp.equals(compareword)){
						if(!outputTemp.contains(compareword)){
							//System.out.println(compareword);
							outputTemp.add(compareword);
							
						}
					}
				}
			}	
		}
	}
	
	static ArrayList<String> sort(ArrayList<String> inList){
		ArrayList<String> newList = new ArrayList<String>();
		//System.out.println(inList.toString());
		while(!inList.isEmpty()){
			int min = 0;
			for(int i = 0; i < inList.size(); i++){
				String currMin = inList.get(min);
				String currInd = inList.get(i);
				
				if(currInd.compareTo(currMin) <= -1){
					min = i;
				}
			}
			//System.out.println(inList.get(min));
			String asscheeks = inList.get(min);
			newList.add(asscheeks);
			inList.remove(min);
			
		}
		
		return newList;
		//System.out.println(newList.toString());
	}
	

}
