const input = require("fs").readFileSync(0).toString().trim().split("\n").map(a=>+a);
const N = input.shift();
for(let i=1; i<=N; i++){
    result = Math.min(...input);
    console.log(result);
    input.splice(input.indexOf(result),1);
}

