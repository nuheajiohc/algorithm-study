N = int(input());
budget = list(map(int, input().split()));
M = int(input());
s= sum(budget)
min_value = 1
max_value = 100000
answer=0
if s<=M:
    print(max(budget))
else:
    while min_value<=max_value:
        mid=(min_value+max_value)//2
        budget_sum=0
        for value in budget:
            if value<mid:
                budget_sum+=value
            else:
                budget_sum+=mid
        if budget_sum>M:
            max_value=mid-1
        elif budget_sum<=M:
            min_value=mid+1
            answer=mid
    print(answer)