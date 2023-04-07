def solution(n, words):
    answer = [0,0]
    unique_words = set()
    r=0
    order=0
    for i in range(len(words)):
        r=i//n
        order=i%n
        if i>=1:
            if words[i-1][-1]!=words[i][0]:
                answer[0]=order+1
                answer[1]=r+1
                break
        if words[i] not in unique_words:
            unique_words.add(words[i])
        else:
            answer[0]=order+1
            answer[1]=r+1
            break
    return answer