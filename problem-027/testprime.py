import sys

def isprime(number):
    if number<=1 or number%2==0:
        return 0
    check=3
    maxneeded=number
    while check<maxneeded+1:
        maxneeded=number/check
        if number%check==0:
            return 0
        check+=2
    return 1

for i in range(1000):
    sys.stdout.write(str(isprime(982451653)))

