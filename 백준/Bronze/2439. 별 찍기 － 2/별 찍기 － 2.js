const input = parseInt(require("fs").readFileSync(0).toString());

let output = "";
for (let i = 1; i <= input; i++) {
    output = " ".repeat(input - i) + "*".repeat(i);
    console.log(output);
}