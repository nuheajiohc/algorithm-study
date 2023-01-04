const input = require("fs").readFileSync(0).toString().split("\n").map(a => +a);
const n = 42;
let arr = [];

for (let i = 0; i < n; i++) {
    arr[i] = 0;
}

for (let i = 0; i < 10; i++) {
    arr[input[i] % 42] += 1;
}

let count = 0;
for (let i = 0; i < n; i++) {
    if (arr[i] >= 1) {
        count++;
    }
}
console.log(count);