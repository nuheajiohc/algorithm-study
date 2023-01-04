const input = require("fs").readFileSync(0).toString().split("\n");


for (let i = 1; i <= Number(input[0]); i++) {
    let sum = 0;
    let avg = 0;
    let cnt = 0;
    let result = 0;
    let number = input[i].split(" ");
    for (let j = 1; j <= Number(number[0]); j++) {
        sum += Number(number[j]);
    }
    avg = sum / Number(number[0]);
    for (let j = 1; j <= Number(number[0]); j++) {
        if (avg < Number(number[j])) {
            cnt++;
        }
    }
    result = cnt / Number(number[0]) * 100;
    console.log(`${result.toFixed(3)}%`);
}