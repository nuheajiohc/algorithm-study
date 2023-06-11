def rotate(arr):
    return list(zip(*arr[::-1]))

def get_new_lock(arr):
    new_lock=[[0]*3*len(arr) for _ in range(3*len(arr))]
    for i in range(len(arr)):
        for j in range(len(arr)):
            new_lock[i+len(arr)][j+len(arr)]= arr[i][j]
    return new_lock

def is_match(n,attached_lock):
    for i in range(n,2*n):
        for j in range(n,2*n):
            if attached_lock[i][j]!=1:
                return False
    return True
            
            
def attach(key,lock,x,y):
    for i in range(x,len(key)+x):
        for j in range(y,len(key)+y):
            lock[i][j]+=key[i-x][j-y]
    return lock
    
def check(n,m,key,lock):
    for i in range(n-m,2*n):
        for j in range(n-m,2*n):
            new_lock=get_new_lock(lock)
            attached_lock=attach(key,new_lock,i,j)
            if is_match(n,attached_lock):
                return True
    return False

def solution(key, lock):
    m,n=len(key),len(lock)
    answer = False
    if check(n,m,key,lock):
        return True
    
    for i in range(3):
        key=rotate(key)
        if check(n,m,key,lock):
            return True
    return answer