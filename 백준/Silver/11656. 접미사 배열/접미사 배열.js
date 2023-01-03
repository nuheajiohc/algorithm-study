const input = require("fs").readFileSync(0).toString().trim().split("");

const strList = [];
const originalLength = input.length;
strList.push([...input].join(""));
for (let i = 1; i < originalLength; i++) {
  input.shift();
  const a = [...input];
  strList.push(a.join(""));
}
console.log(strList.sort().join("\n"));
