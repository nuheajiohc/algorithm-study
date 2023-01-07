const input = require("fs").readFileSync(0).toString().trim().split("\n");
const FirstLine = input[0].split(" ");
const N = Number(FirstLine[0]);
const k = Number(FirstLine[1]);
const students = input[1].split(" ").map(a => +a);
console.log(students.sort((a, b) => b - a)[k - 1]);