import java.util.ArrayList;
import java.util.List;
public class LT_1415_KthLexicographicalHappyString {
//	public static String getHappyString(int n, int k) {
//		List<String> happyStrings = new LinkedList<>();
//		Queue<String> queue = new LinkedList<>();
//		backtracking("", happyStrings, queue, n);
//		if(k > happyStrings.size())
//			return "";
//		Iterator<String> it = happyStrings.iterator();
//		for(int i = 0; i < k -1; i++)
//			it.next();
//		System.out.println(happyStrings);
//		return it.next();
//	}
//	
//	private static void backtracking(String s, List<String> list, Queue<String> queue, int n) {
//		int len = s.length();
//		if(len >= 2 && s.charAt(len - 1) == s.charAt(len - 2))
//			return;
////		list.add(s);
//		if(len == n) {
//			list.add(s);
//			return;
//		}
//		char[] letters = {'a', 'b','c'};
//		for(int i = 0; i < 3; i++) {
//			queue.add(s + letters[i]);
//		}
//		while(!queue.isEmpty())
//			backtracking(queue.poll(), list, queue, n);
//	}
	
	public static String getHappyString(int n, int k) {
		ArrayList<String> happyStrings = new ArrayList<>();
		backtracking("", happyStrings, n);
		if(k > happyStrings.size())
			return "";
		return happyStrings.get(k -1);
	}
	
	private static void backtracking(String s, List<String> list, int n) {
		int len = s.length();
		if(len >= 2 && s.charAt(len - 1) == s.charAt(len - 2))
			return;
		if(len == n) {
			list.add(s);
			return;
		}
		char[] letters = {'a', 'b','c'};
		for(int i = 0; i < 3; i++) {
			backtracking(s + letters[i], list, n);
		}
			
	}
	
	
	public static void main(String[] args) {
		System.out.println(getHappyString(3, 9));;
	}
}
