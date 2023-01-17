const [S,q,...question] = require("fs").readFileSync(0).toString().trim().split("\n");
let prefixSum = [];
const result = question.map(el => {
  let [letter, L, R] = el.split(" ");
  return S.slice(Number(L), Number(R) + 1).split(letter).length - 1;
});
console.log(result.join("\n"));
