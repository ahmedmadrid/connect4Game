package connect_n_points;


public class Board {

	
	public void loadMyArrayWithSapces(char arr[][], int maxRow, int maxCol) {
		for(int i=0; i < maxRow; ++i){
			for(int j =0; j < maxCol; ++j){
				arr[i][j] = ' ';
			}
		}
	}

	
//  no need for telling java arr length since char arr will be passed by reference
	public boolean isFilled(char arr[][], int maxCol) {
		boolean filled = false;
		for(int i =0, j =0; j < maxCol; ++j){
			if(arr[i][j] != ' '){
				filled = true;
			}
			else{
				filled = false;
				break;
			}
		}
		if(filled)
			return true;
		return false;
	}
	
	public void printNewArray(char arr[][], int maxRow, int maxCol) {
		for(int i=0; i < maxRow; ++i){
			for(int j =0; j < maxCol; ++j){
				System.out.print(arr[i][j]+ "  |  ");
			}
			System.out.println();
		}
	}
	
}
