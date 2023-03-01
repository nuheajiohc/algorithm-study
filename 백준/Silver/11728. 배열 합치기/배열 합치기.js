let [_, first, second] = require("fs").readFileSync(0).toString().trim().split("\n");
const result = [];
first = first.split(" ").map(Number);
second = second.split(" ").map(Number);
let i = 0;
let j = 0;
for (let order = 0; order < first.length + second.length; order += 1) {
  if (
    first[i] !== undefined &&
    second[j] != undefined &&
    first[i] <= second[j]
  ) {
    result.push(first[i]);
    i += 1;
  } else if (
    first[i] !== undefined &&
    second[j] != undefined &&
    first[i] > second[j]
  ) {
    result.push(second[j]);
    j += 1;
  } else if (first[i] === undefined && second[j] != undefined) {
    result.push(second[j]);
    j += 1;
  } else {
    result.push(first[i]);
    i += 1;
  }
}
console.log(result.join(" "));
