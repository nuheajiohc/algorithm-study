const input = require("fs").readFileSync(0).toString();

let sum = 0;
for (let i = 1; i <= parseInt(input); i++) {
    sum += i;
}
console.log(sum);