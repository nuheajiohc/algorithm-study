 const [str, M, ...command] = require("fs")
   .readFileSync(0)
   .toString()
   .split("\n");

const strList = str.split("");
const stack = [];

command.forEach(el => {
  if (el === "L" && strList.length) {
    stack.push(strList.pop());
  } else if (el === "D" && stack.length) {
    strList.push(stack.pop());
  } else if (el === "B" && strList.length) {
    strList.pop();
  } else if (el[0] === "P") {
    strList.push(el.split(" ")[1]);
  }
});

console.log(strList.join("") + stack.reverse().join(""));