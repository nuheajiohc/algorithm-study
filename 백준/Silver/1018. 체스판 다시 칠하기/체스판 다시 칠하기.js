const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input[0].split(" ")[0]);
const M = Number(input[0].split(" ")[1]);
const WFirst = ['WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW'];
const BFirst = ['BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB'];
input.shift();
const changeArr = [];
let cnt1 = 0;
let cnt2 = 0;
for (i = 0; i <= N - 8; i++) {
    for (j = 0; j <= M - 8; j++) {
        for (k = 0; k < 8; k++) {
            for (l = 0; l < 8; l++) {
                if (WFirst[k][l] !== input[i + k][j + l]) {
                    cnt1++;
                }
                if (BFirst[k][l] !== input[i + k][j + l]) {
                    cnt2++;
                }
            }
        }
        changeArr.push(cnt1);
        changeArr.push(cnt2);
        cnt1 = 0;
        cnt2 = 0;
    }
}
console.log(Math.min(...changeArr));