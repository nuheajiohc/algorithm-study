N = int(input())
A = sorted(list(map(int,input().split())))

if N>2:
    result=2
    for start in range(N-2):
        end=start+2
        while end<N:
            if A[start]+A[start+1]<=A[end]:
                break
            end+=1
        result=max(result,end-start)
    print(result)
else:
    print(N)