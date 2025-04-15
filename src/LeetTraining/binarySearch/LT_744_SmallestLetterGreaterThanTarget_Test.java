package LeetTraining.binarySearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LT_744_SmallestLetterGreaterThanTarget_Test {

	@Test
	void testTarget() {
        char[] letters = new char[24];
        for(int i = 0; i < 24; i++) {
        	letters[i] = (char)('a' + i);
        }
        for(int i = 0; i < 23; i++){
        	char target = (char)('a' + i);
        	assertEquals(letters[i+1], LT_744_SmallestLetterGreaterThanTarget.nextGreatestLetter(letters, target), "");
        }
	
    }
}
