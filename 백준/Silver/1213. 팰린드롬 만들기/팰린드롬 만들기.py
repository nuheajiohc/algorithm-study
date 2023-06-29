from collections import defaultdict

def func():
    s = input()
    alphabet = defaultdict(int)
    for v in s:
        alphabet[v]+=1
    
    cnt=0
    temp=""
    for v in alphabet:
        if alphabet[v]%2==1:
            cnt+=1
            temp=v
        if cnt>1:
            print("I'm Sorry Hansoo")
            return
    
    sorted_alphabet=sorted(alphabet.items())
    new_s = ""
    
    for (v,i) in sorted_alphabet:
        new_s+=v*(i//2)

    reverse_new_s = new_s[::-1]
    if temp:
        new_s+=temp

    new_s+=reverse_new_s
    print(new_s)

func()