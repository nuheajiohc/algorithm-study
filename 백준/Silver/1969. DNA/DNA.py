from collections import Counter

N,M =map(int,input().split())
DNA_list =[input() for _ in range(N)]

dna = ["T","A","C","G"]
answer=""
count=0
for i in range(M):
    temp=[]
    
    for j in range(N):
        temp.append(DNA_list[j][i])

    temp=sorted(temp)
    ans = Counter(temp).most_common()
    answer+=ans[0][0]
    count+=N-ans[0][1]

print(answer)
print(count)