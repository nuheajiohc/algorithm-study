const input = require("fs").readFileSync(0).toString().split("\n");
let alphabet = [];
let result = 0;

for (let i = 1; i <= input[0]; i++) {
    let cnt = 0;
    for (let j = 0; j < 26; j++) {
        alphabet[j] = 0;
    }
    for (let k = 0; k < input[i].length - 1; k++) {
        if (input[i][k] !== input[i][k + 1]) {
            alphabet[input[i].charCodeAt(k) - 97] += 1;
        }
    }
    alphabet[input[i].charCodeAt(input[i].length - 1) - 97] += 1;
    for (let j = 0; j < 26; j++) {
        if (alphabet[j] <= 1) {
            cnt++;
        } else {
            break;
        }
    }
    if (cnt === 26) {
        result++;
    }
}
console.log(result);