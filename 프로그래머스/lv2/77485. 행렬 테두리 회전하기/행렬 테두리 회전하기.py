def rotate(query,arr):
    x1,y1,x2,y2=map(lambda x:x-1,query)
    
    temp = [arr[x1][y2],arr[x2][y2],arr[x2][y1]]
    min_v =min(temp)

    for i in range(y2,y1,-1):
        arr[x1][i]=arr[x1][i-1]
        min_v = min(min_v,arr[x1][i])
    
    for i in range(x2,x1+1,-1):
        arr[i][y2]=arr[i-1][y2]
        min_v = min(min_v,arr[i][y2])
    arr[x1+1][y2]=temp[0]
   
    for i in range(y1,y2):
        arr[x2][i]=arr[x2][i+1]
        min_v = min(min_v,arr[x2][i])
    arr[x2][y2-1] = temp[1]
    
    for i in range(x1,x2-1):
        arr[i][y1]=arr[i+1][y1]
        min_v = min(min_v, arr[i][y1])
    arr[x2-1][y1]=temp[2]
    
    return [arr,min_v]
    
    
def solution(rows, columns, queries):
    answer = []
    arr = [[i for i in range(row*columns+1,row*columns+columns+1)] for row in range(rows)]
    
    for query in queries:
        arr,min_v = rotate(query,arr)
        answer.append(min_v)
        
    return answer