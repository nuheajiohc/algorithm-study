const input = Number(require("fs").readFileSync(0).toString());
let result = '';
for (let i = 1; i <= input; i++) {
    result += i + '\n';
}
console.log(result);