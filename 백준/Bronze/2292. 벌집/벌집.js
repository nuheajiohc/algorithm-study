const input = Number(require("fs").readFileSync(0).toString());

let n=2;
let sum1=2;
let sum2=1;
while(true){
    if(input==1){
        n=1;
        break;
    }
    sum1+=6*(n-2);
    sum2+=6*(n-1);
    if(input>=sum1 && input<=sum2){
        break;
    }
    n++;
}
console.log(n);
