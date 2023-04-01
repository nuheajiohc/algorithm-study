attendance=[0 for i in range(31)]
for i in range(28):
    attendance[int(input())]=1
for i in range(1,31):
    if attendance[i]==0:
        print(i)

