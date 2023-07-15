l,c = map(int,input().split())
alpha = sorted(input().split())
moeum = {"a","e","i","o","u"}
arr=[]

def func(k,moeum_num,jaeum_num):
    if len(arr)==l and moeum_num>0 and jaeum_num>1:
        print("".join(arr))
        return
    
    for i in range(k,c):
        arr.append(alpha[i])
        if alpha[i] in moeum:
            func(i+1,moeum_num+1,jaeum_num)
        else:
            func(i+1,moeum_num,jaeum_num+1)
        arr.pop()

func(0,0,0)