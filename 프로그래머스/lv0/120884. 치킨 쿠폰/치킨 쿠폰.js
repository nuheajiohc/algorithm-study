function solution(chicken) {
    if(chicken<10) return 0;
    const new_chicken=parseInt(chicken/10);
    const coupon = chicken%10;
    return new_chicken + solution(new_chicken+coupon);
}