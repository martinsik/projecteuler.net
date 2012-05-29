from bigfloat import *

for i in range(2, 10):
    #with precision(300):
    num = str(div(1, BigFloat(i), context=precision(300)))
    dec = num[num.index('.')+1:]

    middle = len(dec) / 2 + 1
    for j in range(0, middle):
        substr = dec[j:middle]
        if dec.find(substr, middle) != -1:
            print substr
            break

    #num = BigFloat(i, precision(100))
    #print BigFloat(i)
    #print 1 / num
    #print str(i) + ' ' + 1 / BigFloat(i), precision=100))


