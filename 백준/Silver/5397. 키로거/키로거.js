const input = require("fs").readFileSync(0).toString().trim().split("\n");
input.shift();
const result = input.map(el => {
  const password = [];
  const popStorage = [];
  for (let i = 0; i < el.length; i += 1) {
    if (el[i] === "<") {
      if (password.length) popStorage.push(password.pop());
      continue;
    } else if (el[i] === ">") {
      if (popStorage.length) password.push(popStorage.pop());
      continue;
    } else if (el[i] === "-") {
      password.pop();
      continue;
    }
    password.push(el[i]);
  }
  return [...password, ...popStorage.reverse()].join("");
});
console.log(result.join("\n"));