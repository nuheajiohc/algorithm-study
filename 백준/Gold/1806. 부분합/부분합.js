const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, S] = input[0].split(" ").map(Number);
const nums = input[1].split(" ").map(Number);

let en = 0;
let sum = nums[0];
let minLength = N + 1;
for (let st = 0; st < N; st += 1) {
  while (en < N && sum < S) {
    en += 1;
    if (en !== N) sum += nums[en];
  }
  if (en === N) break;
  minLength = Math.min(minLength, en - st + 1);
  sum -= nums[st];
}

if (minLength === N + 1) minLength = 0;

console.log(minLength);
