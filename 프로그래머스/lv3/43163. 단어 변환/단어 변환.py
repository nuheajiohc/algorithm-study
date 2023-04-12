from collections import deque

def solution(begin, target, words):
    answer = 0
    words_dict = dict.fromkeys(words,0)
    queue = deque([begin])
    while queue:
        word=queue.popleft()
        for w in words_dict:
            count=0
            for i in range(len(w)):
                if len(w)==len(word) and w[i]==word[i]:
                    count+=1
            if count==len(w)-1:
                if w in words_dict and words_dict[w]>0:
                    continue
                queue.append(w)
                if word==begin:
                    words_dict[w]=1
                else:
                    words_dict[w]=words_dict[word]+1
    if target in words_dict:
        answer=words_dict[target]     
    return answer