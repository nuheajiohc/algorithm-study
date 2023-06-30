t = int(input())
for _ in range(t):
    s=input()
    st=0
    en=len(s)-1
    while st<=en:
        if s[st]==s[en]:
            st+=1
            en-=1
        else:
            break
    else:
        print(0)
        continue
    
    temp1=s[:st]+s[st+1:]
    temp2=s[:en]+s[en+1:]
    
    if temp1==temp1[::-1] or temp2==temp2[::-1]:
        print(1)
    else:
        print(2) 