const input = require("fs").readFileSync(0).toString().split("\n").map(n=>+n);

const a = input[0];
const b = input[1];
let sum = 0;
let min=b;
let cnt =0;
for(let i=a;i<=b;i++){
    if(i===2){
        sum=i;
        min=i;
        continue;
    }
    if(i==1){
        continue;
    }
    for(let j=2; j<i;j++){
        if(i%j===0){
            cnt++;
            break;
        }
    }
    if(cnt===0&&(i!==2)){
        sum+=i;
        if(min>i){
            min=i;
        }
    }
    cnt=0;
}
if(sum===0){
    console.log(-1);
    return 0;
}
console.log(sum);
console.log(min);