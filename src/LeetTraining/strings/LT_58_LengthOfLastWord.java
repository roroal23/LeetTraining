package LeetTraining.strings;

public class LT_58_LengthOfLastWord {
	
	/**	Given a string s consisting of words and spaces, return the length of the last word in the string.
		A word is a maximal consisting of non-space characters only.
	 * @param s String s consisting of words and spaces
	 * @return	Return the length of the last word in the string
	 */
	public int lengthOfLastWord(String s) {
        int i = s.length() - 1;//Start at the end of the string and go backwards
        int n = 0;
        while(i >= 0 && s.charAt(i) == ' ')//Ignore whitespaces
            i--;
        while(i >= 0 && s.charAt(i) != ' '){//Count until the word ends (a whitespace appear)
            i--;
            n++;
        }
        return n;
        
    }

}
