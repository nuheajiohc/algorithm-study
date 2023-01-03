const input = require("fs").readFileSync(0).toString().trim().split("\n").slice(1).map(a => +a);

input.sort((a, b) => a - b);
let sum = 0;
const numMap = [];
for (i of input) {
    sum += i;
    if (numMap[i]) {
        numMap[i] += 1;
    } else {
        numMap[i] = 1;
    }
}
let avg = Math.round(sum / input.length);
if (avg === -0) {
    avg = 0;
}
let FreqNum = Math.max(...Object.values(numMap));
let FreqValue = new Array();
for (let numKey in numMap) {
    if (numMap[numKey] == FreqNum) {
        FreqValue.push(numKey);
    }
}
const FreqSort = FreqValue.map(a => +a).sort((a, b) => a - b);

let Freq = 0;
if (FreqSort.length > 1) {
    Freq = FreqSort[1];
} else {
    Freq = FreqSort[0];
}

console.log(avg);
console.log(input[(input.length - 1) / 2]);
console.log(Freq);
console.log(input[input.length - 1] - input[0]);