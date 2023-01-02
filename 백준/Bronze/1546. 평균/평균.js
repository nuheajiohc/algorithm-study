const input = require("fs").readFileSync(0).toString().split("\n");


const score = input[1].split(" ").map(a => +a);
let sum = 0;
let max = 0;
for (let i = 0; i < score.length; i++) {
    if (score[i] > max) {
        max = score[i];
    }
}
for (let i = 0; i < parseInt(input[0]); i++) {
    sum += score[i] / max * 100;
}
console.log(sum / score.length);