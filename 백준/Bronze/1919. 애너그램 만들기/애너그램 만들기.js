const [a, b] = require("fs").readFileSync(0).toString().trim().split("\n");
const alphabet1 = new Array(26).fill(0);
const alphabet2 = new Array(26).fill(0);

for (let i = 0; i < a.length; i += 1) {
  alphabet1[a.charCodeAt(i) - 97] += 1;
}

for (let i = 0; i < b.length; i += 1) {
  if (alphabet1[b.charCodeAt(i) - 97]) {
    alphabet1[b.charCodeAt(i) - 97] -= 1;
  } else {
    alphabet2[b.charCodeAt(i) - 97] += 1;
  }
}
const result = [...alphabet1, ...alphabet2].reduce((acc, cur) => acc + cur, 0);
console.log(result);
