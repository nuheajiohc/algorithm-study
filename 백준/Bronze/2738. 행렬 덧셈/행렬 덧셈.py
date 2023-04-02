N,M = map(int,input().split())
A = []
B = []
for j in range(N):
    a=list(map(int, input().split()))
    A.append(a)
for j in range(N):
    a=list(map(int,input().split()))
    B.append(a)
for i in range(N):
    part = []
    for j in range(M):
        part.append(A[i][j]+B[i][j])
    print(*part)  