# def solution(prices):
#     answer = []
#     for i in range(len(prices)):
#         temp=0
#         for j in range(i+1, len(prices)):
#             temp+=1
#             if prices[i]>prices[j]:
#                 break
#         answer.append(temp)
#     return answer

def solution(prices):
    length = len(prices)
    # 모든 가격 max값으로 세팅
    result = [ i for i in range (length - 1, -1, -1)]

    # 주식 가격이 떨어지는 경우를 찾아 수정
    stack = []
    for i in range (length):
        while stack and prices[stack[-1]] > prices[i]:
            j = stack.pop()
            result[j] = i - j
        stack.append(i)
    return result