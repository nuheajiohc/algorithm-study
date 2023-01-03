function isPrime(n){
    if(n===1){
        return false;
    }

    for (let i=2; i<=Math.sqrt(n);i++){
        if(n%i===0){
            return false;
        }
    }
    return true;
}

const input = require("fs").readFileSync(0).toString().split(" ");
const a = Number(input[0]);
const b = Number(input[1]);

for(let i=a; i<=b; i++){
    if(isPrime(i)==true){
        console.log(i);
    }
}