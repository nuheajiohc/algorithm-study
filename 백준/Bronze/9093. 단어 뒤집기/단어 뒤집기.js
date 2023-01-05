const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input.shift());
result = '';
for (let i = 0; i < N; i++) {
    let arr = input[i].split(" ");
    for (let j = 0; j < arr.length; j++) {
        for (let k = arr[j].length - 1; k >= 0; k--) {
            result += arr[j][k];
        }
        result += ' ';
    }
    result += "\n";
}
console.log(result);