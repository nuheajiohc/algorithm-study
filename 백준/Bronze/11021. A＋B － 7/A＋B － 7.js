const input = require('fs').readFileSync(0).toString().split("\n");

t = parseInt(input[0]);

for (let i = 1; i <= t; i++) {
    let a = input[i].split(" ");
    console.log(`Case #${i}: ${parseInt(a[0])+parseInt(a[1])}`);
}