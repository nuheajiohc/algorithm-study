def solution(str1, str2):
    answer=0
    lowerstr1=str1.lower()
    lowerstr2=str2.lower()
    list1 = []
    list2 = []
    for i in range(len(lowerstr1)-1):
        if lowerstr1[i:i+2].isalpha():
            list1.append(lowerstr1[i:i+2])

    for i in range(len(lowerstr2)-1):
        if lowerstr2[i:i+2].isalpha():
            list2.append(lowerstr2[i:i+2])
            
    list1copy1= list1.copy()
    list1copy2 = list1.copy()
    union =list1.copy()
    intersection = []
    for i in list2:
        if i in list1copy1:
            list1copy1.remove(i)
        else:
            union.append(i)
    unionlen =len(union)
    for i in list2:
        if i in list1copy2:
            list1copy2.remove(i)
            intersection.append(i)
    intersectionlen = len(intersection)
    if unionlen ==0:
        answer=65536
    else:
        answer = intersectionlen*65536/unionlen
    answer//=1
    return answer

# 합집합
# list2돌면서 해당 요소가 list1 카피본에 있으면 list1 카피본에서 제거
# list2돌면서 해당 요소가 list1 카피본에 없으면 union에 추가

# 교집합
# list2돌면서 해당 요소가 list1 카피본에 있으면 list1카피본에서 제거 intersection에서 추가