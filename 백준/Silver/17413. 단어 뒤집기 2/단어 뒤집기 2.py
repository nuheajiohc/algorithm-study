S = input()

i=0
result=""
stack=[]
while i<len(S):
    if S[i]=="<":
        while S[i]!=">":
            result+=S[i]
            i+=1
        result+=S[i]
        i+=1
    elif S[i]==" ":
        result+=S[i]
        i+=1
    else:   
        while (i<len(S) and S[i]!="<") and (i<len(S) and S[i]!=" "):
            stack.append(S[i])
            i+=1
        stack.reverse()
        result+="".join(stack)
        stack=[]

print(result)
        