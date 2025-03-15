package LeetTraining.math;

public class LT_7_ReverseInteger {
	public static int reverse(int x) {
        int inv = 0;
        while (x != 0) {
            int digito = x % 10;
            if(hasOVF(inv, digito))
                return 0;
            inv = (inv * 10) + digito;
            x /= 10;
        }
        return inv;
    }

    private static boolean hasOVF(int inv, int digito){
        boolean posOVF = inv > Integer.MAX_VALUE / 10 || (inv == Integer.MAX_VALUE / 10 && digito > 7);
        boolean negOVF = inv < Integer.MIN_VALUE / 10 || (inv == Integer.MIN_VALUE / 10 && digito <-8);
        return posOVF || negOVF;
    }
}
