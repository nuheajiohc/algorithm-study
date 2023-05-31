s=input()
min_val=""
max_val=""
cnt=0
for i in range(len(s)):
    cnt+=1
    if s[i]=="K":
        max_val+="5"+"0"*(cnt-1)
        if cnt==1:
          min_val+="5"
        else:
          min_val+=str(10**(cnt-2))+"5"
        cnt=0

if cnt:
   max_val+="1"*cnt
   min_val+="1"+"0"*(cnt-1)
print(max_val,min_val,sep="\n")