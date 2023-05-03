from itertools import combinations

N = int(input())
S = list(map(int,input().split()))
lis = [False for _ in range(2000001)]

for v in S:
    lis[v]=True

for i in range(2,len(S)+1):
    c = combinations(S,i)
    for case in c:
      lis[sum(case)]=True


for i in range(1,2000001):
   if not lis[i]:
      print(i)
      break