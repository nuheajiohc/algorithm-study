import sys

n = int(input())
n_list = list(map(int,sys.stdin.readline().rstrip().split()))
m = int(input())
m_list = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(m)]
d=[[0]*(n+1) for _ in range(n+1)]

def check(st,en):
    while st>0 and en<=n:
        if n_list[st-1]==n_list[en-1]:
            d[st][en]=1
        else:
            break
        st-=1
        en+=1

for i in range(1,n+1):
    st=i
    en=i
    check(st,en)
    st=i
    en=i+1
    check(st,en)

for (s,e) in m_list:
    print(d[s][e])