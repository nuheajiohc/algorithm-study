const [N, ...commandList] = require("fs").readFileSync(0).toString().trim().split("\n");
const dequeue = [];
const result = [];

commandList.forEach(el => {
  const [command, input] = el.split(" ");
  switch (command) {
    case "push_front":
      dequeue.unshift(input);
      break;
    case "push_back":
      dequeue.push(input);
      break;
    case "pop_front":
      if (dequeue.length === 0) {
        result.push(-1);
        break;
      }
      result.push(dequeue.shift());
      break;
    case "pop_back":
      if (dequeue.length === 0) {
        result.push(-1);
        break;
      }
      result.push(dequeue.pop());
      break;
    case "size":
      result.push(dequeue.length);
      break;
    case "empty":
      result.push(dequeue.length ? 0 : 1);
      break;
    case "front":
      result.push(dequeue.length ? dequeue[0] : -1);
      break;
    case "back":
      result.push(dequeue.length ? dequeue.at(-1) : -1);
  }
});
console.log(result.join("\n"));
