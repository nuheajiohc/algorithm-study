from collections import deque

S = list(input())
T = deque(input())
flag=True
while len(S)<len(T):
    if flag:
      if T[-1]=="A":
         T.pop()
      else:
         T.pop()
         flag=False
    else:
       if T[0]=="A":
          T.popleft()
       else:
          T.popleft()
          flag=True
if not flag:
   T= list(T)[::-1]
if "".join(S)=="".join(T):
   print(1)
else:
   print(0)