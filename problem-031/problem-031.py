from collections import deque

#coins = [ 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01 ]
maxVal = 2
#coins = [ 2, 1, 0.5, 0.2, 0.1 ]
#coins = [ 2, 1, 0.5, 0.2 ]
#coins = [ 5, 10, 20, 50, 100 ]
coins = [ 0.05, 0.1, 0.2, 0.5, 1 ]
maxLen = len(coins)
maxRange = range(0, len(coins))
called = [ ]

# recursive
def iteration(combination):
    #if combination in called:
    #    return 0;

    called.append(combination)

    #val = sum(i*j for i, j in zip(combination, coins))
    # calculate value
    val = 0
    for i in maxRange:
        val += combination[i] * coins[i]


    if val == maxVal:
        #print len(called), combination
        return 1
    else:
        total = 0
        for i in range(0, level):
            if val + coins[i] > maxVal:
                break;
            else:
                newList = list(combination)
                newList[i] += 1

                if newList not in called:
                    #print 'X', newList, range(level, maxLen)
                    total += iteration(newList)
                
        return total

#print iteration(len(coins) * [0])

#quit()


# iterative
callstack = deque([[0] * len(coins)])
levels = []

total = 0
while callstack:
    combination = callstack.popleft()

    called.append(combination)

    # calculate value
    val = 0
    for i in maxRange:
        val += combination[i] * coins[i]

    if val == maxVal:
        #print len(found), combination
        total += 1
    else:
        for i in maxRange:
            add = True
            if val + coins[i] > maxVal:
                break;
            else:
                #newList = list(combination)
                newList = list(combination)
                newList[i] += 1

                #print newList

                #if newList not in callstack and newList not in found:
                #try:
                #    called.index(newList)
                #except:
                #    callstack.append(newList)
                #if newList not in callstack and newList not in called:
                if newList not in called and newList not in callstack:
                    callstack.append(newList)
                #for j in range(len(called) - 1, -1, -1):
                #for j in range(0, len(called)):
                #    if called[j] == newList:
                #        add = False
                #        break

                #if add:
                #    callstack.append(newList)

print 'total combinations:', total + 1
print 'len(called):', len(called)

