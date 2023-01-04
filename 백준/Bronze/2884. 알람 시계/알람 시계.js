const input = require("fs").readFileSync("/dev/stdin").toString().split(" ");

const h = parseInt(input[0]);
const m = parseInt(input[1]);

sum_m = ((h * 60) + m - 45) % 1440;
if (sum_m < 0) {
    console.log(23, 60 + sum_m);
    return 0;
}
new_h = parseInt(sum_m / 60);
new_m = sum_m % 60;
console.log(new_h, new_m);