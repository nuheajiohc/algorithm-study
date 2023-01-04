const [a, b] = require("fs").readFileSync(0).toString().split(" ");


let new_a = "";
let new_b = "";

for (let i = a.length - 1; i >= 0; i--) {
    new_a += a[i];
}
new_a = Number(new_a);

for (let i = b.length - 1; i >= 0; i--) {
    new_b += b[i];
}
new_b = Number(new_b);

console.log(new_a > new_b ? new_a : new_b);