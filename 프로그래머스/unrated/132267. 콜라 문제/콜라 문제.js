function solution(a, b, n) {
    let serviceBottle=(Math.floor(n/a))*b;
    let remainingBottle =n%a;
    let fullBottle=serviceBottle+remainingBottle;
    let totalServiceBottle=serviceBottle;
    
    while(fullBottle>=a){
        serviceBottle=Math.floor(fullBottle/a)*b;
        remainingBottle=fullBottle%a;
        fullBottle=serviceBottle+remainingBottle;
        totalServiceBottle+=serviceBottle;
    }
    answer= totalServiceBottle;
    return answer;
}