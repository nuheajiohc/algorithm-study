const [x, y, w, h] = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);

let distance = [x, y, w - x, h - y];

console.log(Math.min(...distance));