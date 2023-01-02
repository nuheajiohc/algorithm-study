let input = require("fs").readFileSync(0).toString().trim().split("\n");
inputArr = input.map(a => a.split(""));
let result = '';
for (i of inputArr) {
    if (String(i.slice().reverse()) === String(i)) {
        if (i[0] === '0')
            continue;
        result += 'yes\n';
    } else {
        result += 'no\n';
    }
}
console.log(result);