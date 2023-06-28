import sys
input = sys.stdin.readline
n,m = map(int, input().split())
no_hear = {input() for i in range(n)}
no_see = {input() for i in range(m)}

intersection = sorted(no_hear & no_see)

print(len(intersection))
print("".join(intersection))