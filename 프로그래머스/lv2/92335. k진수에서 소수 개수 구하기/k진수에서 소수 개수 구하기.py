import math

def convert(n,k):
    arr=[]
    while n!=0:
        temp=n%k
        n//=k
        arr.append(temp)
    arr=arr[::-1]
    return "".join(list(map(str,arr)))

def check_prime(p):
    for i in range(2,int(math.sqrt(p))+1):
        if p%i==0:
            return False
    return True


def solution(n, k):
    answer = 0
    converted_n=convert(n,k)
    temp=converted_n.split("0")
    for s in temp:
        if s=="" or s=="1":
            continue
        num=int(s)
        if check_prime(num):
            answer+=1
    return answer