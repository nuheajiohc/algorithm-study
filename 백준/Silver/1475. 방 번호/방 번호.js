const input = require("fs").readFileSync(0).toString().trim().split("").map(Number);
const number = new Array(10).fill(0);
input.forEach(el => (number[el] += 1));
const sumSixNine = Math.ceil((number[6] + number[9]) / 2);
const maxNumber = Math.max(
  ...number.slice(0, 6),
  sumSixNine,
  ...number.slice(7, 9),
);
console.log(maxNumber);