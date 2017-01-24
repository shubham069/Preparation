import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Did not work, one of the cases was failing. Check interviewBit for testing it.
 */

public class SpiralMatrix {
	public static void main(String[] args){
		SpiralMatrix spiral = new SpiralMatrix();
		List<ArrayList<Integer>> a= new ArrayList<ArrayList<Integer>>();
		a.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		a.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		a.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
		ArrayList<Integer> result = spiral.spiralOrder(a);
		for(int res:result)
				System.out.print(res+" ");
	}

	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int rowStart=0, rowEnd= a.size()-1, colStart=0, colEnd=a.get(0).size()-1;
		 int i,j;
		 while(rowStart<=rowEnd && colStart <=colEnd){
		     i= rowStart;
		     j=colStart;
		     for(j=colStart;j<=colEnd;j++ )
		        result.add(a.get(i).get(j));
		      for(i=rowStart+1,j--;i<=rowEnd;i++)
		        result.add(a.get(i).get(j));
		        if(rowStart+1<=rowEnd)
		        {
		            for(j=colEnd-1, i--;j>=colStart;j--)
		                result.add(a.get(i).get(j));
		        }
		        if(colStart+1<=colEnd)
		        {
		            for(i=rowEnd-1,j++;i>=rowStart+1;i--)
		                result.add(a.get(i).get(j));
		        }
		      rowStart++;
		      rowEnd--;
		      colStart++;
		      colEnd--;
		 }
		 // Populate result;
		 return result;
	}

}
