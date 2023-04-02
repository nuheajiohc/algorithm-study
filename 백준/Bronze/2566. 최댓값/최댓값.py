arr = []
for i in range(9):
    row=list(map(int,input().split()))
    arr.append(row)
max_val=-1
max_index = [0,0]
for i in range(9):
    for j in range(9):
        if max_val<arr[i][j]:
            max_val=arr[i][j]
            max_index[0]=i+1
            max_index[1]=j+1

print(max_val)
print(*max_index)