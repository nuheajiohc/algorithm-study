A,B = map(lambda s:int(s[::-1]),input().split())
print(A if A>B else B)