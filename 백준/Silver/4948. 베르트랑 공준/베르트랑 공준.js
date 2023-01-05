function isPrime(n){
    if(n===1){
        return false;
    }
    for(let i=2; i<=Math.sqrt(n); i++){
        if(n%i===0){
            return false;
        }
    }
    return true;
}

const input = require("fs").readFileSync(0).toString().split("\n").map(a=>+a);
let cnt =0;
for(i of input){
    cnt=0
    if(i===0){
        break;
    }
    for(let j=i+1; j<=2*i; j++){
        if(isPrime(j)==true){
            cnt++;
        }
    }
    console.log(cnt);
}