function constructor(n) {
    let sum = n;
    while (n > 0) {
        sum += n % 10;
        n = Math.floor(n / 10);
    }
    return sum;
}

const input = Number(require("fs").readFileSync(0).toString());
for (let i = 0; i <= input; i++) {
    if (constructor(i) === input) {
        console.log(i);
        return 0;
    }
}
console.log(0);