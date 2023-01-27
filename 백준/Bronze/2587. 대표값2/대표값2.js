 const input = require("fs")
   .readFileSync(0)
   .toString()
   .trim()
   .split("\n")
   .map(Number)
   .sort((a, b) => a - b);


const avg = input.reduce((acc, cur) => acc + cur, 0) / 5;
const midValue = input[2];
console.log(avg);
console.log(midValue);
