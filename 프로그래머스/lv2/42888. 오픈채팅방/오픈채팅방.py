def solution(record):
    answer = []
    check={}
    for s in record:
        if len(s.split())==3:
            status,uid,name=s.split()
        else:
            status,uid=s.split()
        if status=="Enter" or status=="Change":
            check[uid]=name
            
    for s in record:
        if len(s.split())==3:
            status,uid,name=s.split()
        else:
            status,uid=s.split()
        if status=="Enter":
            answer.append(f'{check[uid]}님이 들어왔습니다.')
        elif status=="Leave":
            answer.append(f'{check[uid]}님이 나갔습니다.')
    return answer