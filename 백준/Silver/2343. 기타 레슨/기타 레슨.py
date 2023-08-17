n,m = map(int,input().split())
lectures = list(map(int,input().split()))

def check_size(mid):
    s=0
    cnt=1
    for i in range(n):
      if s+lectures[i]>mid:
        cnt+=1
        s=0
      s+=lectures[i]

    if cnt>m:
      return False
    else:
      return True

def binary_search():
    st=max(lectures)
    en=sum(lectures)
    while st<=en:
      mid=(st+en)//2
      status=check_size(mid)
      if status:
        en=mid-1
      else:
        st=mid+1
    return st

print(binary_search())