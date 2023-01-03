const [A, B, C, D] = require("fs").readFileSync(0).toString().split(" ");
console.log(Number(A + B) + Number(C + D));
