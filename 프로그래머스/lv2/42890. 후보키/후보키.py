from itertools import combinations

def index_combination(n):
    arr=[]
    for i in range(n):
        for c in combinations(range(n),i+1):
            arr.append(list(c))
    return arr

def tuple_combination(tup):
    arr=[]
    for i in range(1,len(tup)+1):
        for c in combinations(tup,i):
            arr.append("".join(c))
    return arr

def check_candidate_key(relations):
    answer=[]
    print(len(relations[0]))
    attribute_index=index_combination(len(relations[0]))
    print(attribute_index[0])
    for i in range(len(relations[0])):
        temp=[]
        for j in range(len(relations)):
            temp.append(relations[j][i])
        
        if len(temp)==len(set(temp)):
            for j in answer:
                if set(j)&set(attribute_index[i])==set(j):
                    break
            else:
                answer.append(attribute_index[i])
    print(answer)
    return len(answer)

def solution(relation):
    answer=[]
    relations=[]
    for tup in relation:
        relations.append(tuple_combination(tup))
    
    attribute_index= index_combination(len(relation[0]))
    
    for i in range(len(relations[0])):
        temp=[]
        for j in range(len(relations)):
            temp.append(relations[j][i])
        
        if len(temp)==len(set(temp)):
            for j in answer:
                if set(j)&set(attribute_index[i])==set(j):
                    break
            else:
                answer.append(attribute_index[i])
    return len(answer)