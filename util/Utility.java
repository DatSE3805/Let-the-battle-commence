public class Utility {

	/**
	 * Test whether a specific number is a prime number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a prime number.
	 */
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * Test whether a specific number is a square number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a square number.
	 */
	public static boolean isSquare(int num) {
		int x = (int) Math.sqrt(num);
		return x * x == num;
	}

	public static boolean isFibonacci(int num) {
		return isSquare(5 * num * num + 4) || isSquare(5 * num * num - 4);
	}

	public static int indexFibonacci(int num) {
		int a = 0, b = 1, c = 1;
    	int res = 1;

		while (c < num)
		{
			c = a + b;
			res++;
			a = b;
			b = c;
		}

		return res;
	}
}