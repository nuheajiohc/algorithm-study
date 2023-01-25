const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);
const square = Array.from({ length: N }, (_, i) => input[i + 1].split(" ").map(Number));
const prefixSum = Array.from({ length: N + 1 }, () => new Array(N + 1).fill(0));

square.forEach((row, i) => {
  let sum = 0;
  row.forEach((col, j) => {
    sum += square[i][j];
    prefixSum[i + 1][j + 1] = sum + prefixSum[i][j + 1];
  });
});

const result = [];
for (let i = N + 1; i <= N + M; i += 1) {
  const [x1, y1, x2, y2] = input[i].split(" ").map(Number);
  const sum = prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1];
  result.push(sum);
}
console.log(result.join("\n"));
