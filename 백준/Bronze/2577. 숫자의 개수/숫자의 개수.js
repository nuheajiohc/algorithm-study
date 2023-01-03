const [A, B, C] = require("fs").readFileSync(0).toString().trim().split("\n").map(a => +a);
const mul = A * B * C;
const numArr = new Array(10).fill(0);
for (i of String(mul)) {
    numArr[Number(i)] += 1;
}
console.log(numArr.join("\n"));