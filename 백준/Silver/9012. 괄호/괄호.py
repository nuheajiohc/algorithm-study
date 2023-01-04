import sys

t = int(sys.stdin.readline())

for i in range(t):
    order = sys.stdin.readline()
    stack = []
    for j in order:
        if j == "(":
            stack.append(j)
        elif j ==")":
            if stack:
                stack.pop()
            else:
                print("NO")
                break
     
    else:
        if stack:
             print("NO")
        else:
            print("YES")