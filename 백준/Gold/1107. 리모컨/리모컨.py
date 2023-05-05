N = int(input())
M = int(input())
broken_btn = {}
if M:
    broken_btn = set(input().split())

min_click=abs(100-N)

for k in range(1000000):
    num =str(k)
    for i in range(len(num)):
        if num[i] in broken_btn:
            break
    else:
        min_click=min(min_click,len(str(k))+abs(k-N))

print(min_click)