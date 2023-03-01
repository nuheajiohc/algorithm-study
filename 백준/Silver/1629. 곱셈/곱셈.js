const [A, B, C] = require("fs").readFileSync(0).toString().trim().split(" ").map(BigInt);
function pow(a, b, c) {
  if (b === BigInt(1)) return a % c;
  const temp = pow(a, BigInt(parseInt(b / BigInt(2))), c);
  if (b % BigInt(2) === 0n) return (temp * temp) % c;
  return (temp * temp * a) % c;
}
console.log(parseInt(pow(A, B, C)));