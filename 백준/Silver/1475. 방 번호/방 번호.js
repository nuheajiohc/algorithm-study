const input =require("fs").readFileSync(0).toString().trim()
const number = new Array(10).fill(0);
let sixNineCount = 0;
for (let i = 0; i < input.length; i += 1) {
  if (input[i] === "9" || input[i] === "6") {
    sixNineCount += 1;
    continue;
  }
  number[input[i]] += 1;
}
const maxNumber = Math.max(...number);

console.log(Math.max(Math.ceil(sixNineCount / 2), maxNumber));
