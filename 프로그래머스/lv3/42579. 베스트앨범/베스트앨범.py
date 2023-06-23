from collections import defaultdict

def solution(genres, plays):
    answer = []
    genres_dict=defaultdict(list)
    new_plays=[]
    for (i,play) in enumerate(plays):
        new_plays.append((i,play))
    
    for i in range(len(genres)):
        genres_dict[genres[i]].append(new_plays[i])
        
    for genre in set(genres):
        genres_dict[genre].sort(key=lambda x:(-x[1],x[0]))
    
    genres_sum_dict = defaultdict(int)
    for i in range(len(genres)):
        genres_sum_dict[genres[i]]+=plays[i]
    
    genres_sum_list=[]
    for k,v in genres_sum_dict.items():
        genres_sum_list.append([k,v])
    
    genres_sum_list.sort(key=lambda x:-x[1])
    
    for k,v in genres_sum_list:
        if len(genres_dict[k])>1:
            answer.append(genres_dict[k][0][0])
            answer.append(genres_dict[k][1][0])
        else:
            answer.append(genres_dict[k][0][0])
    return answer