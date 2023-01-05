const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let num = Number(input[0]);
for (let i = 1; i <= num; i++) {
    let sum = 0;
    let cnt = 0;
    for (let j = 0; j < input[i].length; j++) {
        if (input[i][j] === 'O') {
            cnt++;
            sum += cnt;
        } else if (input[i][j] === 'X') {
            cnt = 0;
        }
    }
    console.log(sum);
}