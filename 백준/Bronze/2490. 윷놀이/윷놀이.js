const input = require("fs").readFileSync(0).toString().trim().split("\n");
const Yutnori = {
  0: "D",
  1: "C",
  2: "B",
  3: "A",
  4: "E",
};

const result = input.map(el => {
  const number = el.split(" ").filter(el => el === "1").length;
  return Yutnori[number];
});
console.log(result.join("\n"));
