# 다른 방식으로 푸는 방법이 있던데 저는 잘 이해가 안가요...ㅠㅠ

from itertools import permutations
import copy
T = int(input())
arr= [[[0,0],[0,1],[0,2]],[[1,0],[1,1],[1,2]],[[2,0],[2,1],[2,2]],[[0,0],[1,0],[2,0]],[[0,1],[1,1],[2,1]],[[0,2],[1,2],[2,2]],[[0,0],[1,1],[2,2]],[[0,2],[1,1],[2,0]]]
p = list(permutations(arr,8))

for _ in range(T):
    coins = []
    for __ in range(3):
        coins.append(list(input().split()))
    front=0
    back=0
    for i in range(3):
        for j in range(3):
            if coins[i][j]=="T":
                front+=1
            else:
                back+=1
    if front==9 or back==9:
        print(0)
        continue
    result=9    #최대로 뒤집을 수있는 횟수가 8이기 때문에 그냥 9로 설정
    for i in p:
        coinscopy = copy.deepcopy(coins)    # 각 순열마다 코인의 상태를 변경해야돼서 복사
        cnt=0   #몇번 뒤집는지 카운팅
        f=front # 각 순열에서의 앞면 판단
        b=back  # 각 순열에서의 뒷면 판단
        for j in i:
            cnt+=1  # for문 돌때마다 카운팅
            for x,y in j:
                if coinscopy[x][y]=="T":
                    coinscopy[x][y]="H"
                    f-=1
                    b+=1
                else:
                    coinscopy[x][y]="T"
                    b-=1
                    f+=1
            if f==9 or b==9:
                result=min(result,cnt)      # 한쪽 면으로 다 맞춰지면 최소값 판단 후 for문 탈출
                break
    if result==9:      # 한쪽면으로 다 맞춰지는 경우가 없으면 -1 출력
        print(-1)
    else:              # 그게 아니라면 해당 최소횟수 출력
        print(result)