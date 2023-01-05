const input = require("fs").readFileSync(0).toString().split("\n");

const t = parseInt(input[0]);

for (let i = 1; i <= t; i++) {
    let [a, b] = input[i].split(" ");
    console.log(`Case #${i}: ${+a} + ${+b} = ${+a + +b}`);
}