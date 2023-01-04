 const input = parseInt(require("fs").readFileSync(0).toString());


for (var i = 1; i <= 9; i++) {
    console.log('%d * %d = %d', input, i, input * i);
}