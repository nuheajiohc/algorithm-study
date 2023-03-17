const [A, B, C] = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);
function pow(b) {
  if (b === 1n) return A % C;
  const temp = pow(b / 2n);
  if (b % 2n === 0n) return (temp * temp) % C;
  else return (temp * temp * A) % C;
}

console.log(Number(pow(B)));