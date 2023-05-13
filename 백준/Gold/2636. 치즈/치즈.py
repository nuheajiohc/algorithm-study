from collections import deque

h,w = map(int,input().split())
square = [list(map(int,input().split())) for _ in range(h)]
count=0
cheeze_num=0

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs():
    global cheeze_num
    queue= deque([(0,0)])
    vis = [[0]*w for _ in range(h)]
    vis[0][0]=1
    cnt=0
    while queue:
        x,y=queue.popleft()
        for dir in range(4):
            nx= x + dx[dir]
            ny= y + dy[dir]
            if nx<0 or ny<0 or nx>=h or ny>=w:
                continue
            if vis[nx][ny]:
                continue
            vis[nx][ny]=1
            if square[nx][ny]:
                cnt+=1
                square[nx][ny]=0
                continue
            queue.append((nx,ny))
    if cnt>0:
        cheeze_num=cnt
        return True
    else:
        return False
                
while True:
    if not bfs():
      break  
    count+=1
    
print(count)
print(cheeze_num)