X = int(input())
N = int(input())
sum =0
for i in range(N):
    a,b = map(int,input().split())
    sum+=a*b
print("Yes" if X==sum else "No")