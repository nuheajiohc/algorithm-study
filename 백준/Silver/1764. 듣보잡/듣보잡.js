const input = require("fs").readFileSync(0).toString().split("\n");
const [N, M] = input[0].split(" ").map(a => +a);
const noListen = new Set(input.slice(1, N + 1));
const noSee = input.slice(N + 1);
const noName = [];
let cnt = 0;
noSee.forEach(el => {
    if (noListen.has(el)) {
        noName.push(el);
        cnt++;
    }
});
noName.sort();
console.log(cnt);
console.log(noName.join("\n"));