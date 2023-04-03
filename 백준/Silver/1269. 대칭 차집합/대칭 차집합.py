input()
A=set(input().split())
B=set(input().split())
print(len(A.difference(B)) +len(B.difference(A)))