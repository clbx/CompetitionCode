import java.util.Scanner;

public class Mountain {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = Integer.parseInt(console.nextLine());
		String line = "";
		String[] input;
		int[] heights;
		int[] outputs = new int[n];

		for(int i = 0; i < n; i++) {
			int m = Integer.parseInt(console.nextLine());
			line = console.nextLine();
			input = line.split(" ");
			heights = new int[input.length];
			for(int j = 0; j <heights.length; j++) 
				heights[j] = Integer.parseInt(input[j]);

			int max_index = find_max(heights);
			int[] lower = new int[max_index];
			int[] upper = new int[heights.length - max_index - 1];

			for(int j = 0; j < lower.length; j++)
				lower[j] = heights[j];
			for(int j = 0; j < upper.length; j++)
				upper[j] = heights[max_index + j + 1];

			//			for(int j = 0; j < lower.length; j++) {
			//				System.out.print(lower[j] + " ");
			//			}
			//			
			//			System.out.println("\n");
			//			
			//			for(int j = 0; j < upper.length; j++) {
			//				System.out.print(upper[j] + " ");
			//			}

			//			int[][] sheet = new int[2][lower.length];
			//			for(int j = 0; j < lower.length; j++) {
			//				sheet[0][j] = lower[j];
			//				sheet[1][j] = 0;
			//			}
			//			
			//			sheet[1][lower.length - 1] = 1;
			//			for(int j = lower.length - 2; j >= 0; j--) {
			//				for(int k = lower.length - 1; k > j + 1; k--) {
			//					
			//				}
			//			}

			int left_length = 0;
			int right_length =  0;

			if(lower.length != 0) {
				int[] left_paths = new int[lower.length];
				for(int j = 0; j < left_paths.length; j++)
					left_paths[j] = 1;

				for(int j = left_paths.length - 2; j >= 0; j--) {
					int max = find_max(left_paths);
					if(lower[max] >= lower[j])
						left_paths[j] += left_paths[max];
					else {
						int next_highest = find_next_greatest(lower, left_paths, j);
						if(next_highest != -1)
							left_paths[j] += left_paths[next_highest];
					}
				}

				left_length = left_paths[find_max(left_paths)];
			}
			if(upper.length != 0) {
				int[] right_paths = new int[upper.length];
				for(int j = 0; j < right_paths.length; j++)
					right_paths[j] = 1;

				int[] true_upper = new int[upper.length];
				for(int j = 0; j < upper.length; j++)
					true_upper[j] = upper[upper.length - 1 - j];

				for(int j = right_paths.length - 2; j >= 0; j--) {
					int max = find_max(right_paths);
					if(true_upper[max] >= true_upper[j])
						right_paths[j] += right_paths[max];
					else {
						int next_highest = find_next_greatest(true_upper, right_paths, j);
						if(next_highest != -1)
							right_paths[j] += right_paths[next_highest];
					}
				}

				right_length = right_paths[find_max(right_paths)];
			}
			
			int sum = left_length + right_length + 1;
			outputs[i] = sum;

		}
		
		for(int i = 0; i < outputs.length; i++)
			System.out.println("" + (i+1) + ": " + outputs[i]);
	}

	static int find_max(int[] array) {
		int max_index = 0;
		for(int i = 0; i < array.length; i++)
			if(array[i] >= array[max_index])
				max_index = i;

		return max_index;
	}

	static int find_next_greatest(int[] array, int[] paths, int index) {
		int value = array[index];
		int path = paths[index];

		int path_index = -1;
		int max_path = Integer.MIN_VALUE;

		for(int i = array.length - 1; i > index; i--) {
			if(array[i] >= value && paths[i] >= path && paths[i] > max_path) {
				path_index = i;
				max_path = paths[i];
			}

		}

		return path_index;
	}
}
