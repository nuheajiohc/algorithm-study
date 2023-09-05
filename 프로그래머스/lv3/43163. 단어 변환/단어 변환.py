from collections import deque

def solution(begin, target, words):
    answer = 0
    words_set = set(words)
    words_dict = dict()
    queue = deque()
    if target in words_set:
        for word in words:
            words_dict[word]=0
        
        words_dict[begin]=0
        queue.append(begin)
        while queue:
            str = queue.popleft()
            for word in words:
                if words_dict[word]:
                    continue
                cnt=0    
                for i in range(len(str)):
                    if str[i]==word[i]:
                        cnt+=1
                if cnt==len(str)-1:
                    queue.append(word)
                    words_dict[word]=words_dict[str]+1
                    if target == word:
                        return words_dict[target]
    return answer