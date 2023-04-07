def solution(s):
    l = sorted(map(int, s.split()))
    answer = f"{l[0]} {l[-1]}"
    return answer