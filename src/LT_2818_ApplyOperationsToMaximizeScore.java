
import java.util.*;
public class LT_2818_ApplyOperationsToMaximizeScore {
	public static int maximumScore(List<Integer> nums, int k) {
		int n = nums.size();
		/* Hint 1*/
		int[] scores = new int[n];
		for(int i = 0; i < n; i++) {
			scores[i] = factorizeAndGetScore(nums.get(i));
		}
		/* Hint 2: For each nums[i], find the nearest index left[i] on the left (if any) such that 
		 * s[left[i]] >= s[i]. if none is found, set left[i] to -1. Similarly, find the nearest index right[i]
		 * on the right (if any) such that s[right[i]] > s[i]. If none is found, set right[i] to n.
		 * Hint 3: Use a monotonic stack to compute right[i] and left[i].
		 */
		Stack<Integer> stack = new Stack<>();//Monotonic decreasing stack (stores indices of elements in decreasing order)
		int[] left = new int[n];//Nearest greater or equal element on the left
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && nums.get(stack.peek()) > nums.get(i) ) {
				stack.pop();//Pop elements since they are less that the current one
			}
			if(!stack.isEmpty())//If the stack is not empty
				left[i] = stack.peek();//There is a greater/equal element
			else 
				left[i] = -1;//There isn't, so we set it to -1
			stack.push(i);//Push the current index
		}
		stack.clear();
		//We do the same for the right
		int[] right = new int[n];
		
		for(int i = n - 1; i >= 0; i--) {
			while(!stack.isEmpty() && nums.get(stack.peek()) <= nums.get(i) ) {
				stack.pop();//Pop elements since they are smaller that the current one
			}
			if(!stack.isEmpty())//If the stack is not empty
				right[i] = stack.peek();//There is a greater/equal element
			else 
				right[i] = n;//There isn't, so we set it to n
			stack.push(i);//Push the current index
		}
		/* Hint 4:
		 * For each index i, if left[i] + 1 <= l <= i <= r <= right[i] - 1, then s[i] is the maximum value in the
		 * range [l, r]. For this particular i, there are ranges[i] = (i - left[i]) * (right[i] - i) ranges
		 * where index i will be chosen.
		 */
		int[] ranges = new int[nums.size()];
		for(int i = 0; i < nums.size(); i++) {
			ranges[i] = (i - left[i]) * (right[i] - i);
		}
		
		/* Hint 5:
		 * Loop over all elements of nums by non-increasing prime score, each element will be chosen 
		 * min(ranges[i], remainingK)times, where reaminingK denotes the number of remaining operations. 
		 * Therefore, the score will be multiplied by s[i]^min(ranges[i],remainingK).
		 */
		Integer[] indexes = new Integer[n];
		for(int i = 0; i < n; i++)//Add all indexes
			indexes[i] = i;
		Arrays.sort(indexes, (a, b) -> Integer.compare(scores[b], scores[a]));// Descending order of scores
		
		int mod = 1000000007;
		
		long score = 1;
		for(int i = 0; i < n && k > 0; i++) {
			int index = indexes[i];
			int count = Math.min(ranges[index], k);
			score = (score * fastExponentiation(nums.get(index), count, mod)) % mod;
			k -= count;
		}

        return (int) score;
	}
	
	private static int factorizeAndGetScore(int n) {
		Set<Integer> factors = new HashSet<>();
		int root = (int)Math.sqrt(n) + 1;
		int divisor = 2;
		while(divisor < root) {
			if(n % divisor == 0) {//If its divisible, its a factor
				factors.add(divisor);
				n = n / divisor;
			}
			else 
				divisor++;
		}
		if(n > 1) //Prime factor bigger than sqrt(n)
			factors.add(n);
		return factors.size();
	}
	
	private static long fastExponentiation(long base, int exp, int mod) {
		long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) 
            	result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
	}
	
	
	public static void main(String[] args) {
		int[] aux = {8,3,9,3,8};
		List<Integer> nums = new ArrayList<>();
		for(int num: aux) {
			nums.add(num);
		}
		int k = 2;
		System.out.println(maximumScore(nums, k));
	}
}
