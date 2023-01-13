const S = require("fs").readFileSync(0).toString().trim().split("");
let dequeue = [];
let result = "";
S.forEach((el, i) => {
  if (el === "<") {
    result += dequeue.reverse().join("");
    dequeue = [];
    dequeue.push("<");
  } else if (el === ">") {
    dequeue.push(">");
    result += dequeue.join("");
    dequeue = [];
  } else if (dequeue[0] === "<") {
    dequeue.push(el);
  } else if (el === " ") {
    result += dequeue.reverse().join("") + " ";
    dequeue = [];
  } else if (el === el.toLowerCase()) {
    dequeue.push(el);
    if (i === S.length - 1) {
      result += dequeue.reverse().join("");
    }
  }
});
console.log(result);
