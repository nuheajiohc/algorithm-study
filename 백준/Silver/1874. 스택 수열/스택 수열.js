const [n, ...input] = require("fs")
  .readFileSync(0)
  .toString()
  .split("\n")
  .map(Number);

const stack = [];
let result = [];
let count = 1;

for (let i = 0; i < n; i += 1) {
  while (count <= input[i]) {
    stack.push(count);
    result.push("+");
    count += 1;
  }
  if (stack.pop() !== input[i]) {
    result = ["NO"];
    break;
  }
  result.push("-");
}
console.log(result.join("\n"));