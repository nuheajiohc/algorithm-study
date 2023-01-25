const input = require("fs").readFileSync(0).toString().trim().split("\n");
const answer = input.map(line => {
  if (line.length === 1) {
    return;
  }
  const stack = [];
  let result = "yes";
  for (let i = 0; i < line.length; i += 1) {
    if (line[i] === "[") {
      stack.push("[");
    } else if (line[i] === "(") {
      stack.push("(");
    } else if (line[i] === "]") {
      if (stack.length !== 0 && stack.at(-1) === "[") {
        stack.pop();
      } else {
        result = "no";
        break;
      }
    } else if (line[i] === ")") {
      if (stack.length !== 0 && stack.at(-1) === "(") {
        stack.pop();
      } else {
        result = "no";
        break;
      }
    }
    if (i === line.length - 1 && stack.length !== 0) {
      result = "no";
    }
  }
  return result;
});
console.log(answer.join("\n"));
