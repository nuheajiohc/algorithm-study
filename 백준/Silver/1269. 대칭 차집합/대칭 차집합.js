const input = require("fs").readFileSync(0).toString().split("\n");
let Aarr = new Set(input[1].split(" ").map(a => +a));
const Barr = input[2].split(" ").map(a => +a);
Barr.forEach(el => {
    if (!Aarr.has(el)) { Aarr.add(el); } else { Aarr.delete(el); }});
console.log(Aarr.size);