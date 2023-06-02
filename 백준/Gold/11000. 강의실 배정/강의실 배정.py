import sys
import heapq
input = sys.stdin.readline

n = int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
arr.sort(key=lambda x:x[1])
temp=[]
for i in range(len(arr)):
    temp.append((arr[i][0],i))
    temp.append((arr[i][1],i))
temp.sort()
max_room=0
heap=[]
for time,idx in temp:
    if not len(heap):
        heapq.heappush(heap,idx)
        max_room=max(max_room,len(heap))
    else:
        if heap[0]==idx:
            heapq.heappop(heap)
        else:
            heapq.heappush(heap,idx)
            max_room=max(max_room,len(heap))

print(max_room)