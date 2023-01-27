const input = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const oddList = input.filter(el => el % 2 === 1).sort((a, b) => a - b);
if (oddList.length) {
  const sum = oddList.reduce((acc, cur) => acc + cur, 0);
  console.log(`${sum}\n${oddList[0]}`);
} else console.log(-1);