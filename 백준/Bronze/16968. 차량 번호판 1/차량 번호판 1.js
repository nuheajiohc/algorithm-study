const input = require("fs").readFileSync("dev/stdin").toString().split("");
let count = 1;
input.forEach((el, i, array) => {
  if (el === "c") {
    if (el !== array[i - 1]) {
      count *= 26;
    } else {
      count *= 25;
    }
  } else if (el === "d") {
    if (el !== array[i - 1]) {
      count *= 10;
    } else {
      count *= 9;
    }
  }
});
console.log(count);
