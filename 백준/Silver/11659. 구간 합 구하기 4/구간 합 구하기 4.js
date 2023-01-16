const input = require("fs").readFileSync(0).toString().trim().split("\n");
input.shift();
const NList = input.shift().split(" ").map(Number);
const prefixSum = [0];
NList.forEach((el, i) => {
  prefixSum.push(el + prefixSum[i]);
});
const result = input.map(el => {
  const [i, j] = el.split(" ").map(Number);
  return prefixSum[j] - prefixSum[i - 1];
});

console.log(result.join("\n"));