height,width = map(int,input().split())
pic=[]
position=[]
for _ in range(height):
    pic.append(list(input()))
min_d=height
for i in range(width):
    meteor_p=[0,0]
    land_p=[0,0]
    for j in range(height):
        if pic[j][i]=="X":
            position.append([j,i])
            meteor_p=[j,i]
        if pic[j][i]=="#":
            land_p=[j,i]
            break
    if meteor_p==[0,0]:
        continue
    min_d=min(min_d,land_p[0]-meteor_p[0]-1)

position.sort(key=lambda x:-x[0])
for i,j in position:
    pic[i][j]="."
    pic[i+min_d][j]="X"

for i in range(height):
    print("".join(pic[i]))
