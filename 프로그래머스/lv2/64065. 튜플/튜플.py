def solution(s):
    ss=s[2:-2].split("},{")
    ss.sort(key=len)
    answer = []
    for i in ss:
        for j in i.split(","):
            if j not in answer:
                answer.append(j)
    return list(map(int,answer))