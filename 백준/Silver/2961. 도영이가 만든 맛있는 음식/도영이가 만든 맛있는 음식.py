from itertools import combinations

N = int(input())
taste = [list(map(int,input().split())) for _ in range(N)]
bitter=[] 
sweet=[]
for a,b in taste:
    bitter.append(a)
    sweet.append(b)

min_taste=1000000000

for i in range(len(bitter)):
    min_taste=min(min_taste,abs(bitter[i]-sweet[i]))  

bitter_sum=[]
sweet_sum=[]
for i in range(2,N+1):
    b_comb = combinations(bitter,i)
    s_comb = combinations(sweet,i)

    for case in b_comb:
        temp_b_sum=1
        for j in case:
            temp_b_sum*=j
        bitter_sum.append(temp_b_sum)
    
    for case in s_comb:
        temp_s_sum=0
        for j in case:
            temp_s_sum+=j
        sweet_sum.append(temp_s_sum)

for i in range(len(bitter_sum)):
    min_taste=min(min_taste,abs(bitter_sum[i]-sweet_sum[i]))
    
print(min_taste)
