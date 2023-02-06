const input = require("fs").readFileSync(0).toString().trim().split("");
const stack = [];
let stackTop = 0;
let result = 0;
input.map((el, i) => {
  if (el === "(") {
    stack.push(el);
    stackTop += 1;
  } else {
    stack.pop();
    stackTop -= 1;
    if (input[i - 1] === "(") {
      result += stackTop;
    } else {
      result += 1;
    }
  }
});
console.log(result);
