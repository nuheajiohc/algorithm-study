s=input()
cnt=0
min_val=""
max_val=""
m_cnt=0
for i in range(len(s)):
    if s[i]=="M":
        m_cnt+=1
    else:
        if m_cnt:
            max_val+="5"+"0"*(m_cnt)
            min_val+="1"+"0"*(m_cnt-1)+"5"
        else:
            max_val+="5"
            min_val+="5"
        m_cnt=0
if m_cnt:
    max_val+="1"*m_cnt
    min_val+=str(int(10**(m_cnt-1)))
print(max_val)
print(min_val)