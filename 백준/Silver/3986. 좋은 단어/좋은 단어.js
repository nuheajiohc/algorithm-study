const input = require("fs").readFileSync(0).toString().split("\n");
let result = 0;
for (let i = 1; i <= Number(input[0]); i += 1) {
  const stack = [];
  input[i].split("").forEach(el => {
    if (stack.at(-1) === el) {
      stack.pop();
    } else {
      stack.push(el);
    }
  });
  if (stack.length === 0) {
    result += 1;
  }
}
console.log(result);