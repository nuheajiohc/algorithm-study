const input = require("fs").readFileSync(0).toString().toUpperCase();

let alpha = [];
let max = 0;
let cnt = 0;
for (let i = 0; i < 26; i++) {
    alpha[i] = 0;
}

for (let j = 0; j < input.length; j++) {
    alpha[input[j].charCodeAt() - 65] += 1;
}

for (let k = 0; k < 26; k++) {
    if (alpha[k] > max) {
        max = alpha[k];
    }
}
for (let k = 0; k < 26; k++) {
    if (alpha[k] == max) {
        cnt++;
    }
}
if (cnt === 1) {
    console.log(String.fromCharCode(alpha.indexOf(max) + 65));
} else {
    console.log("?");
}