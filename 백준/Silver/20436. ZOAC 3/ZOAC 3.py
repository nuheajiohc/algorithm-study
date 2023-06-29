left,right = input().split()
s = input()
keys_dict = {}
keys = ["qwertyuiop","asdfghjkl","zxcvbnm"]
for i in range(len(keys)):
    for j in range(len(keys[i])):
        keys_dict[keys[i][j]]=(i,j)

cons=set(["q","w","e","r","t","a","s","d","f","g","z","x","c","v"])

x1,y1 = keys_dict[left]
x2,y2 = keys_dict[right]

cnt=0
for v in s:
    next_x,next_y=keys_dict[v]
    if v in cons:  
        cnt+=abs(next_x-x1)+abs(next_y-y1)+1
        x1,y1= next_x,next_y
    else:
        cnt+=abs(next_x-x2)+abs(next_y-y2)+1
        x2,y2= next_x,next_y

print(cnt)