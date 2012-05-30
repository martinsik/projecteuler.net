
def isprime(number):
    global iters
    if number<=1 or number%2==0:
        return 0
    check=3
    maxneeded=number
    while check<maxneeded+1:
        iters = iters+1;
        maxneeded=number/check
        if number%check==0:
            return 0
        check+=2
    return 1

max = 0
iters = 0

for a in range(-999, 1000):
    for b in range(-999, 1000):
        n = 0
        while isprime(n*n + a*n + b) == 1:
            n = n + 1
        if n > max:
            max = n
            print("{0:3d}: {1:4d} {2:4d} product={3:d}".format(max, a, b, a*b))

print "iterations: ", iters