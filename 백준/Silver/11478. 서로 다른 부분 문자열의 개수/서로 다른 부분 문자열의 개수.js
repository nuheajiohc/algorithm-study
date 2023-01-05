const input = require("fs").readFileSync(0).toString().trim();
let result = [];
for (let i = 0; i < input.length; i++) {
    for (let j = i + 1; j <= input.length; j++) {
        result.push(input.slice(i, j));
    }
}
result = new Set(result);
console.log(result.size);