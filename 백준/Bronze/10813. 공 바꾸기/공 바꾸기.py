N,M = map(int,input().split())
basket = [i for i in range(1,N+1)]
for i in range(M):
    a,b=map(int,input().split())
    basket[a-1],basket[b-1]=basket[b-1],basket[a-1]
print(*basket)