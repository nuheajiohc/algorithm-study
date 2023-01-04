const [K,...numberList]= require("fs").readFileSync(0).toString().trim().split("\n").map(Number);
const stack = [];
numberList.forEach(el => (el ? stack.push(el) : stack.pop()));
console.log(stack.reduce((acc, cur) => acc + cur, 0));
