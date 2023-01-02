const [a,b,c] = require("fs").readFileSync(0).toString().split(" ").map(t=>+t);

const margin = c-b;
const cnt = Math.floor(a/margin) + 1;
console.log(margin<=0 ? -1:cnt);