package bigOnotacion.SJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lineal {
	
	long[] fibonacciCache = null;

	public static void main(String[] args) throws Exception {
		Stopwatch stopwatch = Stopwatch.start();
		Lineal lineal = new Lineal();
		LinealExampleType linealExampleType = LinealExampleType.Factorial;
		int nFibonacciCache = 80; // 8 40 80
		lineal.fibonacciCache = new long[nFibonacciCache + 1];
		switch (linealExampleType) {
		case Loop:
			int n = 50;
			lineal.Loop(n);
			break;
			
		case ContainsNeedle:
			List<Integer> List = new ArrayList<Integer>() ;
            List.add(10);
            List.add(18);
            List.add(29);
            List.add(0);
            List.add(75);
            List.add(79);
            
            int needle = 76;
            boolean found = lineal.ContainsNeedle(needle, List);
            System.out.printf("Number %d found? %s  \n", needle, found);
            break;
			
		case Factorial:
			double nFactorial = 100 ;
			double factorial = lineal.Factorial(nFactorial);
			System.out.printf("Factorial of %.0f equal to %.0f \n", nFactorial, factorial);
			break;
		case Fibonacci:
			int nFibonacci = 80; // 8 40 80
			for (int i = 1; i <= nFibonacci; i++) {
				long fibonacci = lineal.Fibonacci(i);
				System.out.printf("fibonacci %d = %d \n", i, fibonacci);
			}
			break;
		case FibonacciCache:
			for (int i = 1; i <= nFibonacciCache; i++) {
				long fibonacci = lineal.FibonacciCache(i);
				System.out.printf("fibonacci %d = %d\n", i, fibonacci);
			}
			break;
		}
		System.out.printf("Time elapsed: %d seconds", stopwatch.time(TimeUnit.SECONDS));
		System.in.read();
	}

	/// Complexity: O(N)
	void Loop(long n) {
		int counter = 1;
		while (counter <= n) {
			System.out.println(counter);
			counter++;
		}
	}

	/// Complexity: O(N)
	boolean ContainsNeedle(int needle, List<Integer> numberList) {
		for (Integer item : numberList) {
			if (item == needle) {
				return true;
			}
		}
		return false;
	}

	/// Complexity: O(N)
	double Factorial(double n) {
		if (n == 1) {
			return 1;
		}
		return n * Factorial(n - 1);
	}

	/// Complexity: O(N)
	long Fibonacci(long n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			return 1;
		}
		long fibonacci = 0;
		long previous = 1;
		long penultimate = 0;
		for (int i = 1; i <= n; i++) {
			penultimate = fibonacci;
			fibonacci = previous + fibonacci;
			previous = penultimate;
		}
		return fibonacci;
	}

	/// Complexity: O(N)
	public long FibonacciCache(int n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			fibonacciCache[n] = 1;
		}
		if (fibonacciCache[n] == 0) {
			fibonacciCache[n] = FibonacciCache(n - 1) + FibonacciCache(n - 2);
		}
		return fibonacciCache[n];
	}


}
