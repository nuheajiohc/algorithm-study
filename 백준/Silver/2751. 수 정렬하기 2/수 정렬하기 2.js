const input = require("fs").readFileSync(0).toString().trim().split("\n").map(a => +a);
const N = input.shift();
input.sort((a, b) => a - b);
console.log(input.join("\n"));