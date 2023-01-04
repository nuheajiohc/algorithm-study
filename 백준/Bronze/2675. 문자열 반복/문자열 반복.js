const input = require("fs").readFileSync(0).toString().split("\n");

for (let i = 1; i <= Number(input[0]); i++) {
    let output = "";
    let test = input[i].split(" ");
    for (let j = 0; j < test[1].length; j++) {
        for (let k = 1; k <= Number(test[0]); k++) {
            output += test[1][j];
        }
    }
    console.log(output);
}