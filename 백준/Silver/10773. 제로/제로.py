import sys

k = int(sys.stdin.readline())

stack = []
for i in range(k):
    number = int(sys.stdin.readline())
    stack.append(number)
    
    if number == 0:
        stack.pop()
        stack.pop()

print(sum(stack))