from itertools import combinations

N = int(input())
soccer = [list(map(int,input().split())) for _ in range(N)]

min_value = 40000
whole = list(range(N))
c = combinations(whole,N//2)
for temp_start in c:
    start=0
    link=0
    temp_link= list(set(whole)-set(temp_start))
    for x,y in combinations(temp_link,2):
        link+=soccer[x][y]+soccer[y][x]
    for x,y in combinations(temp_start,2):
        start+=soccer[x][y]+soccer[y][x]
    min_value=min(min_value,abs(start-link))

print(min_value)