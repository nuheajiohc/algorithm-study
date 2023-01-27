const input = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split(" ")
  .map(Number);
input.sort((a, b) => a - b);
console.log(input.join(" "));