const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input[0]);
const M = Number(input[2]);
let N_Arr = new Set(input[1].split(" ").map(a => +a));
let M_Arr = input[3].split(" ").map(a => +a);
let result = '';
M_Arr.forEach(el => N_Arr.has(el) ? result += "1 " : result += "0 ");
console.log(result);