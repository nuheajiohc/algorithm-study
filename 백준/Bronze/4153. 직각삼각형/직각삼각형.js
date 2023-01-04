let input = require("fs").readFileSync(0).toString().trim().split("\n");
input.pop();
input = input.map(a => a.split(" ").map(a => +a).sort((a, b) => a - b));
result = '';
for (i of input) {
    if ((i[0] ** 2) + i[1] ** 2 === i[2] ** 2) {
        result += 'right\n'
    } else {
        result += 'wrong\n';
    }
}
console.log(result);