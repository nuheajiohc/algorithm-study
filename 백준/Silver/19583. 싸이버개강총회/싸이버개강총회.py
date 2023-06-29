import sys

s,e,q = input().split()
start_time = int(s[:2]+s[3:])
end_time = int(e[:2]+e[3:])
quit_time = int(q[:2]+q[3:])
cnt = 0

records = []  
for line in sys.stdin:
    time,name = line.split()
    records.append((int(time[:2]+time[3:]),name))

check=set()
for record in records:
    if record[0]<=start_time:
        check.add(record[1])
    if quit_time>=record[0]>=end_time:
        if record[1] in check:
            check.remove(record[1])
            cnt+=1

print(cnt)