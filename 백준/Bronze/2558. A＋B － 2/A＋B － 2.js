const input = require("fs").readFileSync(0).toString().trim().split("\n").map(a => +a);

console.log(input[0] + input[1]);