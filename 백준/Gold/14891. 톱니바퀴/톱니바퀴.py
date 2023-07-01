from collections import deque

gear= []
for _ in range(4):
    gear.append(deque(input()))

k = int(input())
for _ in range(k):
    num,direction = map(int,input().split())
    dir_temp = [0,0,0,0]
    if num==1:
        dir_temp[0]=direction
        if gear[0][2]!=gear[1][6]:
            dir_temp[1]=direction*(-1)
            if gear[1][2] != gear[2][6]:
                dir_temp[2]=dir_temp[1]*(-1)
                if gear[2][2]!=gear[3][6]:
                    dir_temp[3]=dir_temp[2]*(-1)
    elif num==2:
        dir_temp[1]=direction
        if gear[1][2]!=gear[2][6]:
            dir_temp[2]=direction*(-1)
            if gear[2][2]!=gear[3][6]:
                dir_temp[3]=dir_temp[2]*(-1)
        
        if gear[0][2]!=gear[1][6]:
            dir_temp[0]=direction*(-1)

    elif num==3:
        dir_temp[2]=direction
        if gear[2][2]!=gear[3][6]:
            dir_temp[3]=direction*(-1)
        
        if gear[1][2]!=gear[2][6]:
            dir_temp[1]=direction*(-1)
            if gear[0][2]!=gear[1][6]:
                dir_temp[0]=dir_temp[1]*(-1)

    else:
        dir_temp[3]=direction
        if gear[2][2]!=gear[3][6]:
            dir_temp[2]=direction*(-1)
            if gear[1][2]!=gear[2][6]:
                dir_temp[1]=dir_temp[2]*(-1)
                if gear[0][2]!=gear[1][6]:
                    dir_temp[0]=dir_temp[1]*(-1)

    for i in range(len(dir_temp)):
        gear[i].rotate(dir_temp[i])

answer=0
for i in range(len(gear)):
    if gear[i][0]=="1":
        answer+=2**(i)

print(answer)
