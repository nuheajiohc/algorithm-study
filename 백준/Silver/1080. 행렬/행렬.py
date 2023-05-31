n,m=map(int,input().split())

def matrix(n,m):
    a=[list(input()) for _ in range(n)]
    b=[list(input()) for _ in range(n)]
    cnt=0
    if n<3 or m<3:
        for i in range(n):
            for j in range(m):
                if a[i][j]!=b[i][j]:
                    print(-1)
                    return
        else:
            print(0)
            return
    for i in range(n-2):
        for j in range(m-2):
            if a[i][j]!=b[i][j]:
                for k in range(i,i+3):
                    for l in range(j,j+3):
                        a[k][l]="1" if a[k][l]=="0" else "0"
                cnt+=1

    for i in range(n):
        for j in range(m):
            if a[i][j]!=b[i][j]:
                print(-1)
                return
    else:
        print(cnt)
matrix(n,m)
            