const input = require("fs").readFileSync(0).toString().trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const arr = [];
const result = [];
for (let q = 1; q <= N; q += 1) {
  arr.push(input[q].split(" ").map(Number));
}
for (let w = N + 2; w < input.length; w += 1) {
  const [i, j, x, y] = input[w].split(" ").map(Number);
  let sum = 0;
  for (let a = i - 1; a <= x - 1; a += 1) {
    for (let b = j - 1; b <= y - 1; b += 1) {
      sum += arr[a][b];
    }
  }
  result.push(sum);
  sum = 0;
}

console.log(result.join("\n"));
