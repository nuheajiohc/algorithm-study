n = int(input())
d = [0]*n
d[0]=1
if n>1:
    d[1]=2
for i in range(2,n):
    d[i]=d[i-1]+d[i-2]
print(d[-1]%10007)