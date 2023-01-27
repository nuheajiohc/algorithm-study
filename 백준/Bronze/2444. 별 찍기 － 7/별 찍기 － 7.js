const input = Number(require("fs").readFileSync(0).toString());
const front = [];
for (let i = 1; i <= input; i += 1) {
  front.push(" ".repeat(input - i) + "*".repeat(2 * i - 1));
}
let back = [...front];
back.pop();
back.reverse();
console.log([...front, ...back].join("\n"));
