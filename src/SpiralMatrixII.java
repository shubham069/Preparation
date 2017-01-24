import java.util.ArrayList;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> matrixList = SpiralMatrixII.generateMatrix(3);
		for(ArrayList<Integer> a:matrixList){
			for(Integer b: a)
				System.out.print(b);
			System.out.println();
		}
	}


	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    int rowStart=0, rowEnd= a-1, colStart=0, colEnd=a-1;
	    int val=1;
	    int[][] matrix = new int[a][a];
	    int i, j, k=0,l=0;
	    ArrayList<ArrayList<Integer>> matrixList = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> rows = new ArrayList<Integer>();
	    while(rowStart<=rowEnd && colStart<=colEnd){
    	    i= rowStart;
    	    j= colStart;
    	    for(j= colStart; j<=colEnd; j++)
    	        matrix[i][j]=val++;
    	    //matrix.add(rows);
    	    //rows.clear();
    	    
    	    for(i=rowStart+1, j--;i<=rowEnd;i++)
    	        matrix[i][j]= val++;
    	   if(rowStart+1<= rowEnd){
    	       for(j = colEnd-1, i--; j>=colStart;j--)
    	            matrix[i][j]=val++;
    	   }
    	   	if(colStart+1<= colEnd){
    	       for(i = rowEnd-1, j++; i>=rowStart+1;i--)
    	            matrix[i][j]=val++;
    	   }
 
    	   
    	   rowStart++;
    	   rowEnd--;
    	   colStart++;
    	   colEnd--;
	    }
	   for(int h= 0; h<a; h++){
	       for(int g = 0; g<a; g++)
	            rows.add(matrix[h][g]);
	       
	       matrixList.add(new ArrayList<Integer>(rows));
	       rows.clear();
	   }
	    return matrixList;
	}

}
