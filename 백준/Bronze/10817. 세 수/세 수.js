const input = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);

input.sort((a, b) => a - b);
console.log(input[1]);