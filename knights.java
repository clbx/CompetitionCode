package knight;

public class knights {

	public static void main(String[] args) {
		int length = 1;
		int direction = 0;
		
		int x = 3;
		int y = 3;
		int[][] board = new int[7][7];
		
		int usage = 0;
		
		for(int i = 1; i < 20; i++){
			board[x][y] = i;
			switch(direction) {
			case 0:
				y++;
				break;
			case 1:
				x--;
				break;
			case 2:
				y--;
				break;
			case 3:
				x++;
				break;
			}	
			
			usage++;
			if(usage == length) {
				usage = 0;
				length++;
				direction++;
			}
			
			if(direction > 3) {
				direction = 0;
			}
		}
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}

