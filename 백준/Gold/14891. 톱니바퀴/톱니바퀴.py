from collections import deque

gear= []
for _ in range(4):
    gear.append(deque(input()))
k = int(input())

def check_right(x,d):
    if x>3 or gear[x-1][2]==gear[x][6]:
        return
    
    if gear[x-1][2]!=gear[x][6]:
        check_right(x+1,-d)
        gear[x].rotate(d)

def check_left(x,d):
    if x<0 or gear[x][2] == gear[x+1][6]:
        return

    if gear[x][2]!=gear[x+1][6]:
        check_left(x-1,-d)
        gear[x].rotate(d) 
    

for _ in range(k):
    num,direction = map(int,input().split())

    check_right(num,-direction)
    check_left(num-2,-direction)
    gear[num-1].rotate(direction)

answer=0
for i in range(len(gear)):
    answer+=(2**(i)) * int(gear[i][0])

print(answer)