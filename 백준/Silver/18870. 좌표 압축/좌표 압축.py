N=int(input())
X =list(map(int, input().split()))
result = []
sortedX=sorted(set(X))
X_dict = {}
for i in range(len(sortedX)):
    if sortedX[i] not in X_dict:
        X_dict[sortedX[i]]=i
    
for i in X:
    result.append(X_dict[i])
print(*result)