import sys

n = int(input())
d=[[0]*6 for _ in range(n)]
for i in range(n):
    a,b = map(int,sys.stdin.readline().split())
    d[i][a]+=1
    d[i][b]+=1
max_student=0
grade=0
for i in range(1,6):
    temp_std=0
    temp_grade=i
    for j in range(n):
        if d[j][i]:
            temp_std+=1
        else:
            if max_student<temp_std:
                max_student=temp_std
                grade=temp_grade
            temp_std=0
    else:
          if max_student<temp_std:
              max_student=temp_std
              grade=temp_grade
          temp_std=0

print(max_student,grade)