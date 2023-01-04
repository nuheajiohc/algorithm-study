let [a, b] = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);
let aArr = [];
let result = 1;
let aa = a;
let bb = b;
for (let i = 2; i <= a; i++) {
    if (a % i === 0) {
        a /= i;
        aArr.push(i);
        i--;
    }
}
for (i of aArr) {
    if (b % i === 0) {
        b /= i;
        result *= i;
    }
}
console.log(`${result}
${aa*bb/result}`);