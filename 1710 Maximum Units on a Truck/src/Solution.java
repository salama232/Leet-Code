import java.util.Arrays;
import java.util.Comparator;

//You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
//
//numberOfBoxesi is the number of boxes of type i.
//numberOfUnitsPerBoxi is the number of units in each box of the type i.
//You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
//
//Return the maximum total number of units that can be put on the truck.
//
// 
//
//Example 1:
//
//Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//Output: 8
//Explanation: There are:
//- 1 box of the first type that contains 3 units.
//- 2 boxes of the second type that contain 2 units each.
//- 3 boxes of the third type that contain 1 unit each.
//You can take all the boxes of the first and second types, and one box of the third type.
//The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
//Example 2:
//
//Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//Output: 91
// 
//
//Constraints:
//
//1 <= boxTypes.length <= 1000
//1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
//1 <= truckSize <= 106



/* 
 * 
 * 1- sort the units desc (second column)
 * 2-   if (remain > 0 && remain >= boxTypes[i][j])
                {
            	 max=max+(boxTypes[i][j]*boxTypes[i][j+1]);
            	 remain=remain-boxTypes[i][j];}
                else if (remain > 0 && remain <= boxTypes[i][j])
                {
                     max=max+(remain*boxTypes[i][j+1]);
                     remain =0;
                }
                else return max;
 * 
 */
public class Solution {

	public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {
            
                        
          // Compare values according to columns
          public int compare(final int[] entry1, 
                             final int[] entry2) {
  
            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[col] <= entry2[col])
            	
                return 1;
            else
                return -1;
          }
        });  // End of function call sort().
    }
	
	
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
    	
    	
    	sortbyColumn(boxTypes,1);
        int max=0;
        int remain=truckSize;
    	 for (int i = 0; i < boxTypes.length; i++) {
             for (int j = 0; j < boxTypes[i].length; j=j+2)
             {
                if (remain > 0 && remain >= boxTypes[i][j])
                {
            	 max=max+(boxTypes[i][j]*boxTypes[i][j+1]);
            	 remain=remain-boxTypes[i][j];}
                else if (remain > 0 && remain <= boxTypes[i][j])
                {
                     max=max+(remain*boxTypes[i][j+1]);
                     remain =0;
                }
                else return max;
             }
            
             
    	 }

    	 return max;
        
}
    
    public static void main (String [] args )
    {
    	
    	int  boxTypes[][]={{4,2},{5,5},{4,1},{1,4},{2,5},{1,3},{5,3},{1,5},{5,5},{1,1}};
    	int truckSize = 24;
    	System.out.println(maximumUnits(boxTypes,truckSize));
    	
    }
    
}
