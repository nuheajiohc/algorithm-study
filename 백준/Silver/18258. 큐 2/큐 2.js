const [number, ...commandList] = require("fs").readFileSync(0).toString().trim().split("\n");
const queue = [];
const result = [];
let head = 0;
let tail = 0;
commandList.forEach(el => {
  const [a, b] = el.split(" ");
  if (a === "push") {
    queue.push(b);
    tail += 1;
  } else if (a === "pop") {
    if (tail - head) {
      result.push(queue[head]);
      head += 1;
    } else {
      result.push(-1);
    }
  } else if (a === "size") {
    result.push(tail - head);
  } else if (a === "empty") {
    tail - head ? result.push(0) : result.push(1);
  } else if (a === "front") {
    if (tail - head) {
      result.push(queue[head]);
    } else {
      result.push(-1);
    }
  } else if (a === "back") {
    if (tail - head) {
      result.push(queue[tail - 1]);
    } else {
      result.push(-1);
    }
  }
});
console.log(result.join("\n"));
