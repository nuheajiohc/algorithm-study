n = int(input())
d= [0,1]

for i in range(2,n+1):
    d.append(d[i-1]+d[i-2])
print(d[-1])