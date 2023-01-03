const input = Number(require("fs").readFileSync(0).toString().trim());
result = "";
for (let i = 1; i <= input; i++) {
    result += `${"*".repeat(i)}${" ".repeat(2*(input-i))}${"*".repeat(i)}\n`;
}
for (let i = input - 1; i >= 1; i--) {
    result += `${"*".repeat(i)}${" ".repeat(2*(input-i))}${"*".repeat(i)}\n`;
}
console.log(result);