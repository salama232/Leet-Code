import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]


public class Solution {
	
	  public static int[] twoSum_BruteForce(int[] nums, int target) {
	        
	        for (int i=0;i<nums.length;i++)
	        {
	            for (int j=i+1;j<nums.length;j++)
	            {
	                if (nums[i]+nums[j] == target)
	                    return new int[] {i,j};
	            }
	        }
	        return new int[]{};
	    }
	  
	  
	  public static int[] twoSum_hashmap(int[] nums, int target) {
		  
		  
		  Map<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
		  
		  
		  for (int i=0;i<nums.length;i++)
		  {
			  int complement=target-nums[i];
			  
			  if (hashmap.containsKey(complement))
				  return new int [] {hashmap.get(complement),i};
			  else 
				  hashmap.put(nums[i],i);
		  }
		  
		  return new int[]{};
	  }
	  
	  
	  public static int[] twoSum_pointer(int[] nums, int target) {
		  int left =0;
		  
		  int right=nums.length-1;
		  
		  Arrays.sort(nums);
		  
		  
		  while (left < right)
		  {
			  if (nums[left]+nums[right]==target)
				  return new int[] {left,right};
			  else if (nums[left]+nums[right]<target)
				  left ++;
			  else 
				  right --;
			  
			  
		}
		  
		  
		  return new int[]{};
	  }

	  
	  
	  public static void main (String [] args )
	  {   
		  int [] nums= {2,7,11,15};
		  int target = 9;
		  int result[]=twoSum_BruteForce(nums,target);
		  for (int i:result)
		  {
			  System.out.print(i+" ");
		  }
		  result=twoSum_hashmap(nums,target);
		  for (int i:result)
		  {
			  System.out.print(i+" ");
		  }
		  
		  result=twoSum_pointer(nums,target);
		  for (int i:result)
		  {
			  System.out.print(i+" ");
		  }
		  
	  }
}
