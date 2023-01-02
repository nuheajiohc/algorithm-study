const [a, b] = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);
let result = [];
let cnt = 1;
let sum = 0;
for (let i = 1; i <= 1000; i++) {
    for (j = 1; j <= i; j++) {
        result.push(i);
        if (cnt >= a && cnt <= b) {
            sum += i;
        }
        cnt++;
        if (cnt > b) {
            break;
        }
    }
    if (cnt > b) {
        break;
    }
}
console.log(sum);