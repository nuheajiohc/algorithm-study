const input = require("fs").readFileSync(0).toString().trim().split("");
const stack = [];
let result = 0;
input.map((el, i) => {
  if (el === "(") {
    stack.push(el);
  } else {
    if (input[i - 1] === "(") {
      stack.pop();
      result += stack.length;
    } else {
      stack.pop();
      result += 1;
    }
  }
});
console.log(result);
