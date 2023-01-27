const input = Number(require("fs").readFileSync(0).toString());
result = "";
for (let i = input; i >= 1; i -= 1) {
  result += " ".repeat(input - i) + "*".repeat(2 * i - 1) + "\n";
}
console.log(result);
