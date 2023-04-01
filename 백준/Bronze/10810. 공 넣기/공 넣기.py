N,M = map(int,input().split())
basket = [0 for i in range(1,N+1)]
for i in range(M):
    i,j,k=map(int,input().split())
    basket[i-1:j] =[k for i in range(j-i+1)]
print(" ".join(list(map(str,basket))))