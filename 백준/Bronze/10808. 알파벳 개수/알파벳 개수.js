const input = require("fs").readFileSync(0).toString().trim();
const count = new Array(26).fill(0);

for (let i = 0; i < input.length; i += 1) {
  const index = input.charCodeAt(i) - 97;
  count[index] += 1;
}
console.log(count.join(" "));
