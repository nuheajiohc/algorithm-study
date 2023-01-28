const [n, a, x] = require("fs").readFileSync(0).toString().trim().split("\n");
const aList = a.split(" ").map(Number);
const aSet = new Set(aList);
const result = aList.reduce((acc, cur) => {
  if (aSet.has(Number(x) - cur) && Number(x) !== 2 * cur) {
    acc += 1;
  }
  return acc;
}, 0);
console.log(result / 2);
