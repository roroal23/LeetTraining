package LeetTraining.slidingWindow;

import java.util.*;
public class LT_3306_SubstringsContainingEveryVowelAndKConsonantsII {
	
	public long countOfSubstrings(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // compute index of next consonant for all indices
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                    newLetter,
                    vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            // while we have a valid window, try to shrink it
            while (
                start < word.length() &&
                vowelCount.keySet().size() == 5 &&
                consonantCount == k
            ) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubstrings += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }

                start++;
            }
            end++;
        }

        return numValidSubstrings;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
	
	
//	public static long countOfSubstrings(String word, int k) {
//        long count = 0;
// 
//        int[] vowels = new int[5];
//        int vowelCount = 0;
//        int consonantCount = 0;
//        
////        int lastConsonant = -1;
//        int left = 0;
//        int right = 0;
////        int minLength = k + 5;
//        while(right < word.length()) {
//        	char c = word.charAt(right);
////        	System.out.println("Left: " + left + " Right: " + right + " C:" + c);
////        	System.out.println("Substring: " + word.substring(left, right + 1));
//        	
//        	if(isVowel(c)) {
//        		int vowelIndex = vowelIndex(c);
//        		if(vowels[vowelIndex] == 0)
//        			vowelCount++;
//        		vowels[vowelIndex]++;
//        	}
//        	else
//        		consonantCount++;
//        	
//        	while(vowelCount == 5 && consonantCount >= k) {
//        		count += word.length() - right;
//        		//Si sobrepasamos el numero de consonantes, movemos el izquierdo
//        		//Reducimos poco a poco los contadores, asi no perdemos calculos anteriores
//        		char leftChar = word.charAt(left);
//        		if(isVowel(leftChar)) {
//        			int leftVowelIndex = vowelIndex(leftChar);
//        			vowels[leftVowelIndex]--;
//        			if(vowels[leftVowelIndex] == 0)
//        				vowelCount--;
//        		}
//        		else 
//        			consonantCount--;
//        		left++;
//        	}
//        	
//        	//Verificamos si tiene el tamano minimo y si cumple las caracteristicas deseadas
////        	if(right - left + 1 >= minLength && isValidSubstring(letters, k)) {
////        		count += (right - left + 1) - minLength + 1;
////        		System.out.println("Subcadena válida: " + word.substring(left, right + 1));
////        	}
//        	right++;
//     
//        }    
//        return count;
//	}
//	private static boolean isVowel(char c) {
//		String vowels = "aeiou";
//		return vowels.indexOf(c) != -1;
//	}
//	
//	private static int vowelIndex(char c) {
//		String vowels = "aeiou";
//		return vowels.indexOf(c);
//	}
	
//	private static boolean isValidSubstring(int[] letters, int k) {
//		return letters[0] > 0 && letters[1] > 0 && letters[2] > 0 &&
//				letters[3] > 0 && letters[4] > 0 && letters[5] == k;
//	}
	
	
	public static void main(String[] args) {
		String s = "iqeaouqi";
		int k = 2;
//		System.out.println(countOfSubstrings(s, k));
	}
	
//	countLetter(letters, c);
//	if(c == 'a')
//		letters[0] = letters[0] + 1;
//	else if(c == 'e')
//		letters[1] = letters[1] + 1;
//	else if(c == 'i')
//		letters[2] = letters[2] + 1;
//	else if(c == 'o')
//		letters[3] = letters[3] + 1;
//	else if(c == 'u')
//		letters[4] = letters[4] + 1;
//	else {
//		letters[5] = letters[5] + 1;
//    	if(letters[5] <= k) {
//    		System.out.println("Registro last: " + right);
//			lastConsonant = right;
//    	}
//	}
//	System.out.println("Letras: " + Arrays.toString(letters));
//	if(letters[5] > k) {//Si sobrepasamos el numero de consonantes, reinicia todo
//		System.out.println("Reinicio a " + (lastConsonant +1) );
//		left = lastConsonant + 1;
//		right = left;
//		for(int i = 0; i < letters.length; i++) 
//			letters[i] = 0;
////		lastConsonant = -1;
//	}
//	else {
//		if(isValidSubstring(letters, k)) {//Si es un substring valido, aumentamos la cuenta y seguimos
//			System.out.println("Activa:" + word.substring(left, right + 1));
//    		count++;
//		}
//		right++;
//	}
//
//}
//return count;        
//}


}
