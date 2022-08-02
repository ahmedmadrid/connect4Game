package connect_n_points;

public class Win {
	
	public  boolean check_curr_row(char arr[][], int maxCol, int maxPoints, int i) {
		int j = 0;
		int cnt = 0;
		int idx_j = 0;
		int value_j = 1;
		int len = maxPoints - 1;
		
		int dir_j[] = new int[len];
		int temp = len;
		while(temp > 0) {
			dir_j[idx_j] = value_j;
			--temp;
			++idx_j;
			++value_j;
		}
		int d = 0;
		while(d < len) {
			int new_j = j + dir_j[d];
			if(new_j < maxCol) {
				if(arr[i][j] == arr[i][new_j] && arr[i][j] != ' ') {
					cnt +=1;
				} else {
					cnt = 0; d = 0;
					j = new_j;
					continue;
				}
			}
			++d;
		}
		
		if(cnt == maxPoints-1) {
			return true;
		}
		return false;
	}
	
	public boolean check_curr_col(char arr[][], int maxRow, int maxPoints, int j) {
		int i = 0; 
		int idx_i = 0;
		int value_i = 1;
		int len = maxPoints - 1;
		int dir_i [] = new int [len];
		int temp = len;
		while(temp > 0) {
			dir_i[idx_i] = value_i;
			++idx_i; ++value_i;
			-- temp;
		}
		
		int cnt = 0;
		int d = 0;
		while(d < len) {
			int new_i = i + dir_i[d];
			if(new_i < maxRow) {
				if(arr[i][j] == arr[new_i][j] && arr[i][j] != ' ') {
					cnt++;
				}
				else {
					cnt = 0; d = 0;
					i = new_i;
					continue;
				}
			}
			++d;
		}
		
		if(cnt == maxPoints-1) {
			return true;
		}
		return false;	
	}
	
	public boolean check_curr_left_diagonal(char arr[][], int maxRow, int maxCol, int maxPoints, int r, int c) {
		int i, j;
		
		if(r > c) {
			i = r - c;
			j = 0;
		} else if(r < c) {
			i = 0;
			j = c - r;
		} else {
			i = 0;
			j = 0;
		}
		
		int idx_i = 0, idx_j = 0;
		int value_i = 1, value_j = 1;
		int len = maxPoints - 1;
		
		int dir_i[] = new int[len];
		int dir_j[] = new int[len];
		
		int temp = len;
		while(temp > 0) {
			dir_i[idx_i] = value_i;
			dir_j[idx_j] = value_j;
			++idx_i; ++idx_j;
			++value_i; ++value_j;
			-- temp;
		}
		
		int cnt = 0; int d = 0;
		while(d < len) {
			int new_i = i + dir_i[d];
			int new_j = j + dir_j[d];
			
			if(new_i < maxRow && new_j < maxCol) {
				if(arr[i][j] != ' ' && arr[i][j] == arr[new_i][new_j]) {
					cnt++;
				} else {
					d = 0; cnt = 0;
					i = new_i;
					j = new_j;
					continue;
				}
			}
			++d;
		}
		
		if(cnt == maxPoints-1)
			return true;
		return false;
		
	}
	
	public boolean check_curr_right_diagonal(char arr[][], int maxRow, int maxCol, int maxPoints, int r, int c) {
		int i, j;

		if ((r + c) > maxCol) {
			i = r + c - maxCol - 1;
			j = maxCol - 1;
		} else if ((r + c) < maxCol) {
			i = 0;
			j = r + c;
		} else {
			i = 0;
			j = maxCol - 1;
		}

		int idx_i = 0, idx_j = 0;
		int value_i = 1, value_j = -1;
		int len = maxPoints - 1;

		int dir_i[] = new int[len];
		int dir_j[] = new int[len];
		int temp = len;
		while (temp > 0) {
			dir_i[idx_i] = value_i;
			dir_j[idx_j] = value_j;
			++idx_i;
			++idx_j;
			++value_i;
			--value_j;
			--temp;
		}

		int cnt = 0, d = 0;
		while (d < len) {
			int new_i = i + dir_i[d];
			int new_j = j + dir_j[d];

			if (new_i < maxRow && new_j > -1) {
				if ((arr[i][j] == arr[new_i][new_j]) && arr[i][j] != ' ') {
					cnt++;
				} else {
					cnt = 0;
					d = 0;
					i = new_i;
					j = new_j;
					continue;
				}
			}
			++d;
		}
		if (cnt == maxPoints - 1)
			return true;
		return false;
	}

}
