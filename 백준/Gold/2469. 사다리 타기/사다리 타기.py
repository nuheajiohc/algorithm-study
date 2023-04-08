k = int(input())  # 사람 수
n = int(input())  # 사다리 높이 (가로줄 그을 수 있는)
final_order = list(input()) # 최종 위치
ladder = []
for i in range(n):
    ladder.append(list(input()))

alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
init_order = list(alphabet[0:k])
# 사다리 가로 칸수 = 사람 수-1

for line in ladder:
    if "?" in line:
        break
    for i in range(1,k):
        if line[i-1]=="*":
            continue
        else:
            init_order[i-1],init_order[i]=init_order[i],init_order[i-1]

new_ladder=ladder[::-1]
for line in new_ladder:
    if "?" in line:
        break
    for i in range(1,k):
        if line[i-1]=="*":
            continue
        else:
            final_order[i-1],final_order[i]=final_order[i],final_order[i-1]
result=""
for i in range(k-1):
    if init_order[i]==final_order[i]:
        result+="*"
    else:
        if init_order[i]==final_order[i+1] and init_order[i+1]==final_order[i]:
            result+="-"
        else:
            result+="*"

for i in range(len(result)):
    if result[i]=="-":
        init_order[i],init_order[i+1] = init_order[i+1],init_order[i]

if init_order!=final_order:
    result="x"*(k-1)
print(result)