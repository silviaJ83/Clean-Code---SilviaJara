package bigOnotacion.SJ;

import java.io.IOException;

public class ExponentialSJ {


	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		ExponentialSJ exponentialSJ = new ExponentialSJ();
		ExponentialExampleType exponentialExampleType = ExponentialExampleType.Fibonacci;
		switch (exponentialExampleType) {
		case Fibonacci:
			int n = 40; // 8 40 80
			for (int i = 1; i <= n; i++) {
				long fibonacci = exponentialSJ.Fibonacci(i);
				System.out.printf("fibonacci %d = %d\n", i, fibonacci);

			}
			break;
		}

		long end = System.currentTimeMillis();
		long duration = (end - start) / 1000;

		System.out.printf("Time elapsed: %d seconds", duration);

		System.in.read();

	}

	private long Fibonacci(long n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			return 1;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

}
