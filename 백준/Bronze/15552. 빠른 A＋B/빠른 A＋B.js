const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let result = '';
for (let i = 1; i <= input[0]; i++) {
    let a = input[i].split(" ");
    result += Number(a[0]) + Number(a[1]) + '\n';
}
console.log(result);