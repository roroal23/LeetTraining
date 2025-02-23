import java.util.*;

public class LT_1980_UniqueBinaryString {
	public static String findDifferentBinaryString(String[] nums) {
		Set<String> repeated = new HashSet<>(Arrays.asList(nums));
		return backtracking("", repeated);
	}
	
	private static String backtracking(String s, Set<String> repeated) {
		if(repeated.contains(s))//Si la cadena ya esta entre las repetidas
			return null;
		if(s.length() == repeated.size())//Dado que n = nums.length()
			return s;
		String res = backtracking(s + 0, repeated);
		if(res != null)//Si la rama de 0 es la corecta se devuelve
			return res;
		res = backtracking(s + 1, repeated);//Se continua con la rama de 1
		return res;//Sea correcta (!= null) o incorrecta se devuelve res
	}
	
	public static void main(String[] args) {
		String[] nums = {"01", "00"};
		System.out.println("Sol: " + findDifferentBinaryString(nums));
	}
}
