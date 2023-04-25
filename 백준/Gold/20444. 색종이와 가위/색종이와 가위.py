import math

n,k = map(int,input().split())
min_num = n+1
min_i=1
max_num = n+1-math.floor(n/2)
max_i=math.floor(n/2)+1

while min_i<=max_i:
    mid_i = (min_i+max_i)//2
    mid_num = math.ceil((min_num + max_num)/2)
    mid_value= mid_i*mid_num
    if mid_value<k:
        min_i=mid_i+1
        min_num=mid_num-1
    elif mid_value>k:
        max_i = mid_i-1
        max_num=mid_num+1
    else:
        print("YES")
        break
else:
    print("NO")