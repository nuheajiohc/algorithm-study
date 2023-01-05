const input = require("fs").readFileSync(0).toString().split("\n");

for (let i = 0; i < input.length - 1; i++) {
    let [a, b] = input[i].split(" ");
    console.log(+a + +b);
}
return 0;