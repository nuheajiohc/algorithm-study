N =int(input())
pattern = input()
patternAlphabetNum = len(pattern)-1

for _ in range(N):
    s = input()
    starCount=len(s)-patternAlphabetNum
    s_i=0
    if patternAlphabetNum>len(s):
        print("NE")
        continue
    for i in range(len(pattern)):
        if pattern[i]==s[s_i]:
            pass
        elif pattern[i]=="*":
            s_i=i+starCount-1
        else:
            print("NE")
            break
        s_i+=1
    else:
        print("DA")