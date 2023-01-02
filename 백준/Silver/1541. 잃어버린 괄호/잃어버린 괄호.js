let input = require("fs").readFileSync(0).toString();

const result = [];
if (input.includes("-")) {
    input = input.split("-");

    for (let i = 0; i < input.length; i++) {
        result.push(input[i].split("+").map(a => +a).reduce((sum, el) => sum + el));
    }
    let min = result[0];
    for (let i = 1; i < result.length; i++) {
        min -= result[i];
    }
    console.log(min);
} else {
    console.log(input.split("+").map(a => +a).reduce((sum, a) => sum + a));
}