const [N, ...commandList] = require("fs")
  .readFileSync(0)
  .toString()
  .split("\n");
const queqe = [];
const answer = [];

commandList.forEach(el => {
  const [command, integer] = el.split(" ");
  if (command === "push") {
    queqe.push(integer);
  } else if (command === "front") {
    const queqeFront = queqe.length ? queqe.at(0) : -1;
    answer.push(queqeFront);
  } else if (command === "back") {
    const queqeBack = queqe.length ? queqe.at(-1) : -1;
    answer.push(queqeBack);
  } else if (command === "size") {
    answer.push(queqe.length);
  } else if (command === "pop") {
    const queqePop = queqe.length ? queqe.shift() : -1;
    answer.push(queqePop);
  } else if (command === "empty") {
    answer.push(Number(!queqe.length));
  }
});
console.log(answer.join("\n"));
