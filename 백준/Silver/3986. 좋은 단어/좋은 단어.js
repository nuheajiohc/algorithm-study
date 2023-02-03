const input = require("fs").readFileSync(0).toString().trim().split("\n");
let result = 0;
for (let i = 1; i <= Number(input[0]); i += 1) {
  const stack = [];
  let [a, b] = [0, 0];
  input[i].split("").forEach(el => {
    if (stack.length === 0) {
      if (el === "A") {
        a = 1;
      } else {
        b = 1;
      }
      stack.push(el);
    } else {
      if (el === "A") {
        if (a > 0) {
          if (stack.at(-1) === "A") {
            stack.pop();
            a += 1;
          } else {
            stack.push(el);
            a += 1;
          }
        } else {
          stack.push(el);
          a += 1;
        }
      } else {
        if (b > 0) {
          if (stack.at(-1) === "B") {
            stack.pop();
            b += 1;
          } else {
            stack.push(el);
            b += 1;
          }
        } else {
          stack.push(el);
          b = 1;
        }
      }
    }
  });
  if (stack.length === 0) {
    result += 1;
  }
}
console.log(result);