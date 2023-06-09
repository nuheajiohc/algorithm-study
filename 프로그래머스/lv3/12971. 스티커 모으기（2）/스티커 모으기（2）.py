# def solution(sticker):
#     if len(sticker)==1:
#         return sticker[0]
    
#     d1=[sticker[0]]
#     if len(sticker)>1:
#         d1.append(sticker[0])
#     if len(sticker)>2:
#         d1.append(sticker[0])
#     if len(sticker)>3:
#         d1.append(sticker[0]+sticker[2])
#     if len(sticker)>4:
#         d1.append(sticker[0]+sticker[3])
#     for i in range(5,len(sticker)):
#         d1.append(max(d1[i-2],d1[i-3])+sticker[i-1])
    
#     d2=[0]
#     if len(sticker)>1:
#         d2.append(sticker[1])
#     if len(sticker)>2:
#         d2.append(sticker[2])
#     if len(sticker)>3:
#         d2.append(sticker[1]+sticker[3])
#     for i in range(4,len(sticker)):
#         d2.append(max(d2[i-2],d2[i-3])+sticker[i])

#     answer= max(d1[-1],d1[-2],d2[-1],d2[-2])
#     return answer

def solution(sticker):
    d1=[sticker[0],sticker[0],sticker[0]]
    d2=[0,sum(sticker[:2])-sticker[0]]
    if len(sticker)>2:
        d2.append(max(sticker[1:3]))
    for i in range(3,len(sticker)):
        d1.append(max(d1[i-1],d1[i-2]+sticker[i-1]))
        d2.append(max(d2[i-1],d2[i-2]+sticker[i]))
    return max(d1[-1],d2[-1])
