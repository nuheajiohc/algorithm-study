n = int(input())
d = list(map(int,input().split()))
city_cost= list(map(int,input().split()))
cost = 0
min_city_cost=2e9
for i in range(n-1):
    min_city_cost=min(min_city_cost,city_cost[i])
    cost+=min_city_cost*d[i]
print(cost)

