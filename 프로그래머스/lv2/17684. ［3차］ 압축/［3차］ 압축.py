def solution(msg):
    answer = []
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    alp_dict = {}
    for i,al in enumerate(alphabet,1):
        alp_dict[al]=i
    
    temp=""
    j=0
    while j<len(msg):
        temp+=msg[j]
        if temp in alp_dict:
            j+=1
            if j==len(msg):
                answer.append(alp_dict[temp])
        else:
            alp_dict[temp]=len(alp_dict)+1
            answer.append(alp_dict[temp[0:-1]])
            temp=""
    return answer


# msg를 for 문으로 돌린다.
# stack에 for문으로 돌린 msg를 한글자씩 넣기
# 처음글자와 맞는 index를 answer.append(alphabet.index(처음글자))
# 다음 글자가 있다면 stack에서 제거한 글자 기억해두고 그 글자+ 다음글자를 사전에 등록

#현재입력이 dict에 있으면 다음글자까지 받아서 있는지 확인
# 다음글자없을때까지 확인
# 다음글자 없으면 그걸 사전에 추가하고 
# 없는글자부터 다시 확인
