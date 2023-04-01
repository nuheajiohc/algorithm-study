N,X = map(int,input().split())
A = list(map(int,input().split()))
print(" ".join(list(map(str,filter(lambda num:num<X,A)))))