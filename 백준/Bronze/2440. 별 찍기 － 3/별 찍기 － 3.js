const input = Number(require("fs").readFileSync(0).toString().trim());
result = "";
for (let i = input; i >= 1; i--) {
    result += '*'.repeat(i) + "\n"
}
console.log(result);