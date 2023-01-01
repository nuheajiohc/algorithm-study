let input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input.shift());
let rank = '';
input = input.map(a => a.split(" ").map(a=>+a));

for (let i = 0; i < N; i++) {
    let cnt = 1;
    for (let j = 0; j < N; j++) {
        if (input[i][0] < input[j][0]) {
            if (input[i][1] < input[j][1]) {
                cnt++;
            }
        }
    }
    rank += cnt + ' ';
}
console.log(rank);