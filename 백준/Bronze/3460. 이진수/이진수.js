function binaryNumber(a) {
    let k = 0;
    let re = '';
    while (Math.floor(a) !== 0) {
        if (a % 2 !== 0) {
            re += k + " ";
        } else {
            re += "";
        }
        a = Math.floor(a / 2);
        k++;
    }
    return re;
}
const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input[0]);

for (let i = 1; i <= N; i++) {
    console.log(binaryNumber(Number(input[i])))
}