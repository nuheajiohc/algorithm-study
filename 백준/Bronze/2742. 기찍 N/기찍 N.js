const input = Number(require("fs").readFileSync(0).toString());
let result = '';
for (let i = input; i >= 1; i--) {
    result += i + '\n';
}
console.log(result);