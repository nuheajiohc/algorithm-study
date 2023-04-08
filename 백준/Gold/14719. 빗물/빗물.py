H,W = map(int,input().split())
blocks = list(map(int,input().split()))

sum=0

for i in range(1,H+1):
    line_sum=0
    count=0
    flag=False
    for j in blocks:
        if j>=i:
           flag=True
           if count>0:
               line_sum+=count
               count=0
        else:
            if flag:
                count+=1
    sum+=line_sum
print(sum)