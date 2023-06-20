import math

def solution(w,h):
    g=math.gcd(w,h)
    min_num = min(w//g,h//g)
    max_num = max(w//g,h//g)
    b=(min_num+max_num-1)*g
    answer= w*h - b
    return answer