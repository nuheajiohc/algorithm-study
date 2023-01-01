const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input.shift());
input.sort()
input.sort((a, b) => { if (a.length !== b.length) { return a.length - b.length } });
const new_input = new Set(input);
const newArray = Array.from(new_input);
console.log(newArray.join("\n"));