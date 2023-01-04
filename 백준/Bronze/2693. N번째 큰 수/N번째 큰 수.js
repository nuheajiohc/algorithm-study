const input = require("fs").readFileSync(0).toString().trim().split("\n");
input.shift();
result = '';
for (i of input) {
    const arr = i.split(" ").map(a => +a);
    arr.sort((a, b) => b - a);
    result += arr[2] + '\n';
}
console.log(result);