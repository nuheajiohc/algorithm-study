function isPrime(n){
    if(n===1){
        return false;
    }
    for(let i=2; i<n; i++){
        if(n%i==0){
            return false;
        }
    }
    return true;
}

const input = require("fs").readFileSync(0).toString().split("\n").map(a => +a);
input.shift();
for(i of input){
    for(let j=(i/2); j<i;j++){
        if(isPrime(j)){
            if(isPrime(i-j)){
                console.log(`${i-j} ${j}`);
                break;
            }
        }
    }
}