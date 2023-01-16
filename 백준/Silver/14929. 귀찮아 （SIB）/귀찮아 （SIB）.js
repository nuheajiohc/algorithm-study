const [n, x] = require("fs").readFileSync(0).toString().split("\n");
const xList = x.split(" ").map(Number);
let result = 0;
let sum = xList.reduce((acc, cur) => acc + cur, 0);
xList.forEach(el => {
  sum -= el;
  result += el * sum;
});
console.log(result);
