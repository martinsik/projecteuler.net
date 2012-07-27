
min = 2
max = 100

list = [ ]

for a in range(min, max + 1):
    for b in range(min, max + 1):
        mult = a ** b
        if mult not in list:
            list.append(mult)

print 'Items in list:', len(list)

