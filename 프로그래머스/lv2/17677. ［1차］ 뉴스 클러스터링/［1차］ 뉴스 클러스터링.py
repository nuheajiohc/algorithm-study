def solution(str1, str2):
    str1=str1.lower()
    str2=str2.lower()
    possible_str = set()
    str1_dict = {}
    str2_dict = {}
    intersection=0
    union=0
    for i in range(len(str1)-1):
        if not str1[i:i+2].isalpha():
            continue
        possible_str.add(str1[i:i+2])
        if str1[i:i+2] not in str1_dict:
            str1_dict[str1[i:i+2]]=0
        str1_dict[str1[i:i+2]]+=1
        
    for i in range((len(str2)-1)):
        if not str2[i:i+2].isalpha():
            continue
        possible_str.add(str2[i:i+2])
        if str2[i:i+2] not in str2_dict:
            str2_dict[str2[i:i+2]]=0
        str2_dict[str2[i:i+2]]+=1
    
    possible_str = list(possible_str)
    
    for s in possible_str:
        if s in str1_dict and s in str2_dict:
            if str1_dict[s]<=str2_dict[s]: 
                union+=str2_dict[s]
                intersection+=str1_dict[s]
            else:
                union+=str1_dict[s]
                intersection+=str2_dict[s]
        elif s in str1_dict:
            union+=str1_dict[s]
        else:
            union+=str2_dict[s]
    
    if union==0:
        answer=65536
    else:
        answer = (intersection/union)*65536//1
    return answer