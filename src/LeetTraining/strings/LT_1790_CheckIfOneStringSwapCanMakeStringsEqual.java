package LeetTraining.strings;

public class LT_1790_CheckIfOneStringSwapCanMakeStringsEqual {
	
	//16-3:Compared to last version: Renaming and early exit
	public boolean areAlmostEqual(String s1, String s2) {
        int diffs = 0;
        int[][] diffChar = new int[2][2];//Array to save chars that will be swapped
        int i = 0;
        while(i < s1.length()) {
        	char x = s1.charAt(i);
        	char y = s2.charAt(i);
        	if(x != y) {
        		if(diffs >= 2) //If there are already 2 differences, we will need more than 1 swap
        			return false;
        		//We save both chars that are different
        		diffChar[diffs][0] = x;
        		diffChar[diffs][1] = y;
        		diffs++;
        	}
        	i++;
        }
        if(diffs == 0)//If they are equal, no swaps needed
        	return true;
        //The first char from s1 and the second char from s2 must be equal,
        //Also the first char from s2 must be equal to the second char from s1
        return diffChar[0][0] == diffChar[1][1] && diffChar[0][1] == diffChar[1][0];
    }
	
//	public boolean areAlmostEqual(String s1, String s2) {
//        int diffChar = 0;
//        int i = 0;
//        int[] pos = new int[3];
//        while(diffChar <= 2 && i < s1.length()){
//            if(s1.charAt(i) != s2.charAt(i)){
//                pos[diffChar] = i;
//                diffChar++;
//            }
//            i++;
//        }
//        if(diffChar == 0)
//            return true;
//        if(diffChar > 2)
//            return false;
//        return  s1.charAt(pos[0]) == s2.charAt(pos[1]) && 
//                    s1.charAt(pos[1]) == s2.charAt(pos[0]);
//    }
}
