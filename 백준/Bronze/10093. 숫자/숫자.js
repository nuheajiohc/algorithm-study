 const [a, b] = require("fs")
   .readFileSync(0)
   .toString()
   .trim()
   .split(" ")
   .map(Number)
   .sort((a, b) => a - b);

let length = b - a - 1 !== -1 ? b - a - 1 : 0;
let number = "";
for (let i = a + 1; i < b; i += 1) {
  number += i + " ";
}
console.log(length + "\n" + number);