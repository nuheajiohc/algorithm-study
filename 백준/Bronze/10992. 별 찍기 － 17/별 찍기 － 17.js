const input = Number(require("fs").readFileSync(0).toString().trim());

if (input == 1) {
    console.log("*");
    return 0;
}
let result = '';
result += `${' '.repeat(input-1)}*\n`;
for (let i = 2; i < input; i++) {
    result += `${' '.repeat(input-i)}*${' '.repeat((i*2)-3)}*\n`
}
result += '*'.repeat((2 * input) - 1);
console.log(result);