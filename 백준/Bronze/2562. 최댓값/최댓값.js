const input = require("fs").readFileSync(0).toString().split("\n").map(a => +a);

let max = 0;
let index = 0;
for (let i = 0; i < 9; i++) {
    if (input[i] > max) {
        max = input[i];
    }
}
for (let i = 0; i < 9; i++) {
    index++;
    if (input[i] === max) {
        console.log(`${max}
${index}`);
        break;
    }
}