num = int(input())
paper =[[0 for j in range(101)] for i in range(101)]
for i in range(num):
    a,b=map(int, input().split())
    for j in range(a,a+10):
        for k in range(b,b+10):
            paper[j][k]+=1
result=0
for i in range(100):
    for j in range(100):
        if paper[i][j]>=1:
            result+=1
print(result)