const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input[0].split(" ")[0]);
const M = Number(input[0].split(" ")[1]);
const card = input[1].split(" ").map(a => +a).sort((a, b) => a - b);
let sum = 0;
const CardSum = [];
for (let i = 0; i < card.length - 2; i++) {
    for (let j = i + 1; j < card.length - 1; j++) {
        for (let k = j + 1; k < card.length; k++) {
            sum = card[i] + card[j] + card[k];
            if (M >= sum) {
                CardSum.push(sum);
            }
        }
    }
}

console.log(Math.max(...CardSum));