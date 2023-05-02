N=int(input())

prime_num = [1 for _ in range(1003002)]
prime_num[0:2]=[0,0]

for i in range(2,1003002):
    if prime_num[i]==0:
        continue
    for j in range(i*2,1003002,i):
        prime_num[j]=0
i=N
while True:
    if prime_num[i] and str(i)==str(i)[::-1]:
        print(i)
        break 
    i+=1