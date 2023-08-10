k,n = map(int,input().split())
lines = [int(input()) for _ in range(k)]

def binary_search():
    st = 1
    en = max(lines)
    while st<=en:
        mid=(st+en)//2
        cnt=0
        for line in lines:
            if line<mid:
                continue
            else:
                cnt+=line//mid
        
        if cnt<n:
            en=mid-1
        else:
            st=mid+1
    return en

print(binary_search())