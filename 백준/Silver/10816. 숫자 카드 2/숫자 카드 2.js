const input = require("fs").readFileSync(0).toString().trim().split("\n");
const N = Number(input[0]);
const M = Number(input[2]);
const N_Map = new Map();
const N_Arr = input[1].split(" ").map(a => +a).sort((a, b) => a - b);
const M_Arr = input[3].split(" ").map(a => +a);
let cnt = 1;
for (let i = 0; i < N_Arr.length; i++) {
    if (N_Arr[i - 1] === N_Arr[i]) {
        cnt++;
        N_Map.set(N_Arr[i], cnt);
        continue;
    }
    cnt = 1;
    N_Map.set(N_Arr[i], cnt);
}

let result = '';
M_Arr.forEach(el => {
    if (N_Map.has(el)) { result += N_Map.get(el) + " " } else { result += "0 " }
});
console.log(result);