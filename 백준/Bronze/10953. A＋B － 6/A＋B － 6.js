const input = require("fs").readFileSync(0).toString().trim().split("\n");
input.shift();
input.forEach(a => console.log(+a[0] + +a[2]));