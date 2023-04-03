input()
mycards = set(map(int,input().split()))
input()
cards = map(int,input().split())
for card in cards:
    if card in mycards:
        print(1, end=" ")
    else:
        print(0, end=" ")