const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, K] = input[0].split(" ").map(Number);
const coins = input.slice(1).map(Number).reverse();
let count = 0;
let sum = 0;
for (let i = 0; i < coins.length; i += 1) {
  sum += coins[i];
  count += 1;
  if (sum > K) {
    sum -= coins[i];
    count -= 1;
  } else if (sum === K) {
    console.log(count);
    return;
  } else {
    i -= 1;
  }
}
