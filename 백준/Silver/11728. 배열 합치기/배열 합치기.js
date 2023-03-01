let [_, first, second] = require("fs").readFileSync(0).toString().trim().split("\n");
first = first.split(" ").map(Number);
second = second.split(" ").map(Number);
console.log([...first, ...second].sort((a, b) => a - b).join(" "));
