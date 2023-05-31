input()
ball = input()
ball_l = ball[0]
ball_r = ball[-1]
l_i=0
for i in range(len(ball)):
    if ball[i]!=ball_l:
        l_i=i
        break

l_list=ball[l_i:]
r_i=0
for i in range(len(ball)-1,-1,-1):
    if ball[i]!=ball_r:
        r_i=i
        break

r_list=ball[0:r_i+1]
print(min(l_list.count("R"),l_list.count("B"),r_list.count("R"),r_list.count("B")))