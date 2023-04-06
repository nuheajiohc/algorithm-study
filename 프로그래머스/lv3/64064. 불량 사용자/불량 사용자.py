from itertools import permutations

def solution(user_id, banned_id):
    answer = []
    p =permutations(user_id, len(banned_id))
    for i in p:
        for user,ban in zip(i,banned_id):
            if not check(user,ban):
                break
        else:
             banned= set(i)
             if banned not in answer:
                answer.append(banned)
    return len(answer)


def check(user, ban):
    if len(user)!=len(ban):
        return False
    else:    
        for i,j in zip(user,ban):
            if j=="*" or i==j:
                continue
            else:
                return False
        return True
                
                
    

# user_id 배열 크기가 8이하라서 시간복잡도를 신경쓰지않아도 될 정도로 작다
# user_id 를 순열을 이용하여 벤당하는 아이디의 갯수만큼 뽑아서 벤당하는 아이디와 차례대로 다 비교한다.
# 해당 아이디와 밴아이디가 일치하면 카운팅 아니면 넘어가기

# 나는 시간복잡도 충이라서 이렇게 for문 두개 연속으로 돌리는걸 못본다. 그래서 그냥 방법 말고도 무조건 방법이 있을거다 생각하다가 못풀었어
# 일단 코테에 있어서 가장 먼저 생각해야 할건 "조건 확인하고 시간복잡도 확인하기" > 시간복잡도가 널널할 것같으면 완전탐색
# >아니면 시간복잡도에 맞게 알고리즘 생각해서 적용해보기