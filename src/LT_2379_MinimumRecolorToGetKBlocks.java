
public class LT_2379_MinimumRecolorToGetKBlocks {
	public static int minimumRecolors(String blocks, int k) {
        int minRec = blocks.length();
        int recolors;
        for(int i = 0; i + k <= blocks.length(); i++) {
        	recolors = recolorsSubstring(blocks.substring(i, i + k));
        	if(recolors < minRec)
        		minRec = recolors;
        }
        return minRec;
    }
	
	private static int recolorsSubstring(String sub) {
		System.out.println(sub);
		int whiteBlocks = 0;
		for(int i = 0; i < sub.length(); i++) {
			if(sub.charAt(i) == 'W')
				whiteBlocks++;
		}
		return whiteBlocks;
	}
	
	public static void main(String[] args) {
		String block = "BWWWBB";
		System.out.println(minimumRecolors(block, 6));
	}
}
