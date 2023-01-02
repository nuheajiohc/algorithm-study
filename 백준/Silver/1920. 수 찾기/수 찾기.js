const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N_Arr = new Set(input[1].split(" ").map(a => +a));
const M_Arr = input[3].split(" ").map(a => +a);
result = '';
M_Arr.forEach(e => { N_Arr.has(e) ? result += "1\n" : result += "0\n" })
console.log(result);