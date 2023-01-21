const input = require("fs").readFileSync(0).toString().trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const A = input[1].split(" ").map(Number);

const prefixSum = [];
const count = new Array(M).fill(0);
A.forEach(el => {
  prefixSum.push(el + (prefixSum.at(-1) ?? 0));
  count[prefixSum.at(-1) % M] += 1;
});

let result = count[0];
for (let i = 0; i < M; i += 1) {
  result += (count[i] * (count[i] - 1)) / 2;
}
console.log(result);