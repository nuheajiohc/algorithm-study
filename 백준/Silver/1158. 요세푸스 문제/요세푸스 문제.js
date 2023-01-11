const [N, K] = require("fs").readFileSync(0).toString().split(" ").map(Number);
const queue = Array.from({ length: N }, (_, i) => i + 1);
let index = 1;
const result = [];

while (queue.length) {
  const queuePop = queue.shift();
  if (index % K === 0) {
    result.push(queuePop);
  } else {
    queue.push(queuePop);
  }
  index += 1;
}

console.log(`<${result.join(", ")}>`);
