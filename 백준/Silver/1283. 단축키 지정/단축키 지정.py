N = int(input())
option = set()
result=[]
for i in range(N):
    word=input().split()
    optionCheck=False
    for j in range(len(word)):
        if word[j][0].lower() not in option:
            option.add(word[j][0].lower())
            word[j]="[{0}]".format(word[j][0])+word[j][1:]
            optionCheck=True
            result.append(" ".join(word))
            break
    if optionCheck==False:
        for j in range(len(word)):
            for k in range(len(word[j])):
                if word[j][k].lower() not in option:
                    option.add(word[j][k].lower())
                    word[j]=word[j][0:k]+"[{0}]".format(word[j][k])+word[j][k+1:]
                    result.append(" ".join(word))
                    optionCheck=True
                    break
            if(optionCheck==True):
                break
    if optionCheck==False:
        result.append(" ".join(word))
print("\n".join(result))
