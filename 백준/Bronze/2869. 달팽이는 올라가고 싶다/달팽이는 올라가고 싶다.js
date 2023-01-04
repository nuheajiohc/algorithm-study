const input = require("fs").readFileSync(0).toString().split(" ");


const up = Number(input[0]);
const down = Number(input[1]);
const height = Number(input[2]);
console.log(Math.ceil((height-down) / (up -down)));