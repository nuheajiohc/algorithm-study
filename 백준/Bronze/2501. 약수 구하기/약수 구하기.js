const [p,k] = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);
const q = [];

for (let i = 1; i <= p; i++) {
    if (p % i === 0) {
        q.push(i);
    }
}

if (q.length < k) {
    console.log(0);
} else {
    console.log(q[k - 1]);
}