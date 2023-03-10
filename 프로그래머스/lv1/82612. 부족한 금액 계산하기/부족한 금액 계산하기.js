function solution(price, money, count) {
    const totalPrice = (price+price*count)*count/2;
    const answer =money<totalPrice?totalPrice-money:0;
    return answer;
}