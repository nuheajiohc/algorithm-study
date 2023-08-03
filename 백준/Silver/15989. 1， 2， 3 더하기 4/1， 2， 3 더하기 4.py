n = int(input())

d = [1]*(10001)

for i in range(2,10001):
    d[i] += d[i-2]

for i in range(3,10001):
    d[i] += d[i-3]

for i in range(n):
    case=int(input())
    print(d[case])