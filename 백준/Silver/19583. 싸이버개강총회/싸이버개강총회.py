import sys

s,e,q = input().split()
start_time = int(s[:2]+s[3:])
end_time = int(e[:2]+e[3:])
quit_time = int(q[:2]+q[3:])
cnt = 0
 
check=set()
for line in sys.stdin:
    time,name = line.split()
    time=int(time[:2]+time[3:])
    if time<=start_time:
        check.add(name)
    if quit_time>=time>=end_time:
        if name in check:
            check.remove(name)
            cnt+=1    

print(cnt)