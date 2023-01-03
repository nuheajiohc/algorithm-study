const input = require("fs").readFileSync(0).toString().split("\n");

let cnt = 0;
let result = 0;
let prime_number = input[1].split(" ").map(n =>+n);
for(i of prime_number){
    if(i===2){
        result++;
    }
    for(let j=2;j<i;j++){
        if(i%j==0){
            break;
        }else{
            cnt++;
            if(cnt==(i-2)){
                result++;
            }
        }
    }
    cnt = 0;
}
console.log(result);
