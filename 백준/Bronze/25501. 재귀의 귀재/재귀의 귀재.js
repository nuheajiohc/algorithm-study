const input = require("fs").readFileSync(0).toString().trim().split("\n");

const N = Number(input[0]);
let cnt = 0;

function isPalindrome(char, left, right) {
    cnt++;
    if (left >= right) {
        return `1 ${cnt}`;
    } else if (char[left] !== char[right]) {
        return `0 ${cnt}`;
    } else {
        return isPalindrome(char, left + 1, right - 1);
    }
}

function letter(char) {
    return isPalindrome(char, 0, (char.length - 1));
}
for (let i = 1; i <= N; i++) {
    input.shift();
    console.log(letter(input[0]));
    cnt = 0;
}