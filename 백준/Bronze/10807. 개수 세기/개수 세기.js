const [N, number, v] = require("fs").readFileSync(0).toString().trim().split("\n");
console.log(number.split(" ").filter(el => el === v).length);