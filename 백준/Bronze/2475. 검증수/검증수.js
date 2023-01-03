const input = require("fs").readFileSync(0).toString().trim().split(" ");
let sum = 0;
for (i of input) {
    sum += Number(i) * Number(i);
}
console.log(sum % 10);