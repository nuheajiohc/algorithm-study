const input = Number(require("fs").readFileSync(0).toString());

function fibonacci(n) {
    let i = n;
    if (n === 0) {
        return 0;
    } else if (n === 1) {
        return 1;
    }
    return fibonacci(n - 2) + fibonacci(n - 1);
}

console.log(fibonacci(input));