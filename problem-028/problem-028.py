# problem 28

# 21 22 23 24 25
# 20  7  8  9 10
# 19  6  1  2 11
# 18  5  4  3 12
# 17 16 15 14 13

# 43 44 45 46 47 48 49 50
# 42 21 22 23 24 25 26 51
# 41 20  7  8  9 10 27 52
# 40 19  6  1  2 11 28 53
# 39 18  5  4  3 12 29 54
# 38 17 16 15 14 13 30 55
# 37 36 35 34 33 32 31 56
#                      57

# 43                49   
#    21          25      
#        7     9         
#           1            
#        5     3         
#    17          13      
# 37                31   
#                      57

total = 1;
last = 1;
for size in range(3, 1003, 2):
    coef = size - 1;
    for j in range(0, 4):
        last += coef
        total += last


print total