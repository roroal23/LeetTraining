import java.util.HashSet;
import java.util.Set;

public class LT_2375_SmallestNumberDIString {
	public static String smallestNumber(String pattern) {
		return backtracking("", pattern, -2, new HashSet<>());
    }

    private static String backtracking(String s, String pattern, int pos, Set<Integer> added) {

    	if(pos >= 0) {
    		char c = pattern.charAt(pos);
    		char c0 = s.charAt(s.length() - 2);
    		char c1 = s.charAt(s.length() - 1);
    		if((c == 'D' && c0 <= c1) || (c == 'I' && c0 >= c1))
    			return null;
    		if(pos == pattern.length() - 1)
    			return s;
    	}
    	String minLex = null;
    	String aux;
    	for(int i = 1; i <= pattern.length() + 1; i++) {
    		if(!added.contains(i)) {
    			added.add(i);
    			aux = backtracking(s + i, pattern, pos + 1, added);
    			added.remove(i);
    			if(aux != null && (minLex == null || aux.compareTo(minLex) < 0))
    				minLex = aux;
    		}
    	}
    	return minLex;
    }
    
    public static void main(String[] args) {
		String pattern = "IIIDIDDD";
		System.out.println(smallestNumber(pattern));
	}
}
