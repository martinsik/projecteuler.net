arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
num = 1

#def union(a, b):
#    for e in b:
#        a.append(e)

def find_k(inArr):
    for k in range(len(inArr) - 2, -1, -1):
        if inArr[k] < inArr[k+1]:
            return k
    return False

def find_i(inArr, k):
    for i in range(len(inArr) - 1, k, -1):
        if inArr[k] < inArr[i]:
            return i
    return False

k = find_k(arr)
while not isinstance(k, bool): # k != 0
    # if (num % 10000 == 0):
    #    print str(num) + ' ' + str(arr)
    if (num == 10**6):
        print str(num) + ' ' + str(arr)
        break

    i = find_i(arr, k)
    arr[k], arr[i] = arr[i], arr[k]
    nl = arr[k+1:]
    nl.reverse()

    arr = arr[:k+1] + nl
    #union(arr, arr[k+1:].reverse())
    k = find_k(arr)
    num += 1