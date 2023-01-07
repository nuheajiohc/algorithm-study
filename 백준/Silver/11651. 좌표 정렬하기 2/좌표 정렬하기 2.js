const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = input.shift();
const coordinate = [];
for (let i = 0; i < N; i++) {
    coordinate[i] = input[i].split(" ").map(a => +a);
}
coordinate.sort((a, b) => { if (a[1] !== b[1]) { return a[1] - b[1] } return a[0] - b[0] });

let result = '';
coordinate.forEach(x => result += x.join(" ") + '\n');
console.log(result);