const input = require("fs").readFileSync(0).toString().trim().split("").map(a => +a);

input.sort((a, b) => b - a);
console.log(input.join(""));