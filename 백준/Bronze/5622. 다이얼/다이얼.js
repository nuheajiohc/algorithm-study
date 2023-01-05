const input = require("fs").readFileSync(0).toString();

alphabet = [
    ['A', 'B', 'C'],
    ['D', 'E', 'F'],
    ['G', 'H', 'I'],
    ['J', 'K', 'L'],
    ['M', 'N', 'O'],
    ['P', 'Q', 'R', 'S'],
    ['T', 'U', 'V'],
    ['W', 'X', 'Y', 'Z']
];
let cnt = 3;
let sum = 0;

for (let i = 0; i < input.length; i++) {
    for (let key in alphabet) {
        for (let key_2 in alphabet[key]) {
            if (alphabet[key][key_2] === input[i]) {
                sum += cnt + +key;
                break;
            }
        }
    }
}
console.log(sum);