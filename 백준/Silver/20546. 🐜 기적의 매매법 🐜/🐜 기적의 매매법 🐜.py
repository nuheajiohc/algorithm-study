money= int(input())
stock_price = list(map(int, input().split()))

j_money = money
j_stock = 0
j_stock_num=0

s_money = money
s_stock = 0
s_stock_num=0

for price in stock_price:
    if j_money >= price:
        current_sum=j_money//price
        j_stock += price * current_sum
        j_money -= price * current_sum
        j_stock_num+=current_sum

j_money +=stock_price[-1]*j_stock_num

red=0
blue=0
for i in range(len(stock_price)):
    if i>0:
        if stock_price[i-1]>stock_price[i]:
            blue+=1
            red=0
        elif stock_price[i-1]==stock_price[i]:
            blue=0
            red=0
        else:
            red+=1
            blue=0
    if blue>=3:
        current_sum = s_money//stock_price[i]
        s_stock += stock_price[i] * current_sum
        s_money -= stock_price[i] * current_sum
        s_stock_num += current_sum
    if red==3 and s_stock>0:
        s_money += stock_price[i] * s_stock_num
        s_stock_num=0
        s_stock=0

s_money += stock_price[-1]* s_stock_num

if j_money>s_money:
    print("BNP")
elif j_money==s_money:
    print("SAMESAME")
else:
    print("TIMING")