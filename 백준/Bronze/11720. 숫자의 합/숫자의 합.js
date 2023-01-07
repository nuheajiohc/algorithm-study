const input = require("fs").readFileSync(0).toString().split("\n");
result = 0;
for (let i = 0; i < Number(input[0]); i++) {
    result += +input[1][i];
}
console.log(result);