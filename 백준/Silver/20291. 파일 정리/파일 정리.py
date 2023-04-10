N = int(input())
files = {}
for _ in range(N):
    a,b = input().split(".")
    if b not in files:
        files[b]=1
    else:
        files[b]+=1

sorted_files=sorted(list(files.items()),key=lambda x:x[0])
for a,b in sorted_files:
    print(a,b)