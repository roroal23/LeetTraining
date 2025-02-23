import java.util.HashMap;
import java.util.Map;

public class LT_1079_LetterTilesPossibilities {

	public static int numTilePossibilities(String tiles) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < tiles.length(); i++){
			Character c = tiles.charAt(i);
			int frec = map.getOrDefault(c, 0);
			map.put(c, frec + 1);
		}
		return backtracking(map);
	}

	private static int backtracking(Map<Character, Integer> map) {
		int total = 0;
		for(Character c: map.keySet()) {
			int freq = map.get(c);
			if(freq > 0) {
				map.put(c, freq - 1);
				total += 1 + backtracking(map);	
				map.put(c, freq);
			}
		}
		return total;

	}
	
	public static void main(String[] args) {
		String s = "AAB";
		System.out.println(numTilePossibilities(s));
	}
		

}
