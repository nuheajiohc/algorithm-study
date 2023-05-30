n =int(input())
problem = input()
st=0
en=len(problem)-1
cnt=1
temp_color=problem[0]

while st<=en:
    if problem[st]==temp_color:
        st+=1
    else:
        if problem[en]==temp_color:
            en-=1
            pass
        else:
            cnt+=1
            en-=1
            temp_color=problem[st]
            st+=1
print(cnt)