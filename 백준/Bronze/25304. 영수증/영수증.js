const input = require("fs").readFileSync(0).toString().split("\n");

sum_price = parseInt(input[0]);
n = parseInt(input[1]);
let sum = 0;
let a = 0;
for (let i = 1; i <= n; i++) {
    a = input[i + 1].split(" ");
    sum = sum + parseInt(a[0]) * parseInt(a[1]);

}

console.log(sum_price == sum ? "Yes" : "No");