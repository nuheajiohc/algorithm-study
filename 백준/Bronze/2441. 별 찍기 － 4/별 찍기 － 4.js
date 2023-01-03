const input = Number(require("fs").readFileSync(0).toString().trim());
result = '';
for (let i = 0; i < input; i++) {
    result += `${' '.repeat(i)}${'*'.repeat(input - i)}\n`;
}
console.log(result);