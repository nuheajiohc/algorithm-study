n = int(input())
network = []
for _ in range(n):
    network.append(list(map(int,input().split())))

min_cost = 1000000*n
arr = [0]
def func(cost):
    global min_cost
    if len(arr)==n:
        if network[arr[-1]][arr[0]]==0:
            return
        cost+=network[arr[-1]][arr[0]]
        min_cost = min(min_cost,cost)
        return
    
    for i in range(1,n):
        if i not in arr:
            arr.append(i)
            if network[arr[-2]][arr[-1]]==0:
                arr.pop()
                continue
            cost += network[arr[-2]][arr[-1]]
            func(cost)
            cost -= network[arr[-2]][arr[-1]]
            arr.pop()

func(0)
print(min_cost)