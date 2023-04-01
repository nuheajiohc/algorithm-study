N,M = map(int,input().split())
basket = [i for i in range(N+1)]
for cnt in range(M):
    i,j=map(int,input().split())
    basket[i:j+1]=basket[j:i-1:-1]
print(*basket[1:])