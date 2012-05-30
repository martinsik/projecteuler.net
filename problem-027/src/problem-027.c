
#include <stdio.h>

extern long iters = 0;

int is_prime(long number) {
	if (number <= 1 || number % 2 == 0) {
		return 0;
	}
	long check = 3, maxneeded = number;

	while (check < maxneeded + 1) {
		iters++;
		maxneeded = number / check;
		if (number % check == 0) {
			return 0;
		}
		check += 2;
	}
	return 1;
}

int main(void) {
	/*
	printf("length: %d\n", (int) sizeof (int));
	printf("length: %d\n", (int) sizeof (long));
	printf("length: %d\n", (int) sizeof (long long));
	*/

	int a, b, n, max = 0;

	for (a=-999; a < 1000; a++) {
	    for (b=-999; b < 1000; b++) {
	        n = 0;
	        while (is_prime(n*n + a*n + b) == 1) {
	            n++;
	        }
	        if (n > max) {
	            max = n;
	            printf("%d: %d %d product=%d\n", max, a, b, a*b);
	        }
	    }
	}
	printf("iterations: %ld\n", iters);
	return 0;
}

