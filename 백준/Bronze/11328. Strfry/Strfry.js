const input = require("fs").readFileSync(0).toString().trim().split("\n");
input.shift();
const result = input.map(el => {
  const [a, b] = el.split(" ").map(s => s.split("").sort().join(""));
  if (a === b) return "Possible";
  else return "Impossible";
});

console.log(result.join("\n"));