def solution(polynomial):
    answer =[]
    x=0
    n=0
    spl = polynomial.split(" + ")
    for i in spl:
        if "x" in i:
            if i[0]=="x":
                x+=1
            else:
                x+=int(i[0:-1])
        else:
            n+=int(i)
    if x>0:
        if x==1:
            answer.append("x")
        else:
            answer.append(str(x)+"x")
    if n>0:
        answer.append(str(n))
    return " + ".join(answer)