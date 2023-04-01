letter = input()
alphabet = [-1 for i in range(26)]
for s in letter:
    alphabet[ord(s)-97]=letter.index(s)
print(*alphabet)