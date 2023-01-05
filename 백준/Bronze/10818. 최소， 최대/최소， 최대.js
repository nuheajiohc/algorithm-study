const input = require("fs").readFileSync(0).toString().split("\n");
const n = parseInt(input[0]);
const arr = input[1].split(" ").map(number => +number);


let tmp;
let max = arr[0];
let min = arr[0];
for (let i = 0; i < n; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
    if (arr[i] < min) {
        min = arr[i];
    }
}


console.log(min, max)