import heapq

t = int(input())
def case():
    input()
    files =list(map(int,input().split()))
    result=0
    heapq.heapify(files)
    while len(files)>1:
        a=heapq.heappop(files)
        b=heapq.heappop(files)
        heapq.heappush(files,a+b)
        result+=a+b
    return result

for _ in range(t):
    print(case())