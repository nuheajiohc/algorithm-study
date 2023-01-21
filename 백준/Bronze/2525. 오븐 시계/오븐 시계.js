const [time, plus] = require("fs").readFileSync(0).toString().trim().split("\n");
const [A, B] = time.split(" ").map(Number);
const totalMinute = A * 60 + B + Number(plus);
const H = Math.floor(totalMinute / 60) % 24;
const M = totalMinute % 60;
console.log(H, M);
