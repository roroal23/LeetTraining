package LeetTraining.strings;

public class LT_1790_CheckIfOneStringSwapCanMakeStringsEqual {
	public boolean areAlmostEqual(String s1, String s2) {
        int diffChar = 0;
        int i = 0;
        int[] pos = new int[3];
        while(diffChar <= 2 && i < s1.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                pos[diffChar] = i;
                diffChar++;
            }
            i++;
        }
        if(diffChar == 0)
            return true;
        if(diffChar > 2)
            return false;
        return  s1.charAt(pos[0]) == s2.charAt(pos[1]) && 
                    s1.charAt(pos[1]) == s2.charAt(pos[0]);
    }
}
