def check(data):
    max_cnt = 1
    for i in range(N):
        cnt = 1
        for j in range(1, N):
            if data[i][j] == data[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)

        cnt = 1
        for j in range(1, N):
            if data[j][i] == data[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)
    
    return max_cnt

N = int(input())
data = [list(input()) for _ in range(N)]
ans = 0

for i in range(N):
    for j in range(N):
        if j + 1 < N: # 열 범위 체크
            # 인접한 것끼리 바꿔주기
            data[i][j], data[i][j+1] = data[i][j+1], data[i][j]
            cnt = check(data)
            ans = max(ans, cnt)
            # 바꾼 것 원래대로 돌려놓기
            data[i][j], data[i][j+1] = data[i][j+1], data[i][j]

        if i + 1 < N: # 행 범위 체크
            data[i][j], data[i+1][j] = data[i+1][j], data[i][j]
            cnt = check(data)
            ans = max(ans, cnt)
            # 바꾼 것 원래대로 돌려놓기
            data[i][j], data[i+1][j] = data[i+1][j], data[i][j]

print(ans)