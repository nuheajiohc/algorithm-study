const input = parseInt(require('fs').readFileSync(0).toString());

let num = input;
let sum;
let i = 0;

while (true) {
    sum = parseInt(num / 10) + num % 10;
    num = (num % 10) * 10 + sum % 10;
    i++;
    if (input === num)
        break;
}
console.log(i);