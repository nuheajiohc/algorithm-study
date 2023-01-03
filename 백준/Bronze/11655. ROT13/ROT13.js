const input = require("fs").readFileSync(0).toString().split("");

const upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const lowerCase = "abcdefghijklmnopqrstuvwxyz";
const result = input.map(el => {
  if (upperCase.includes(el)) {
    const idx = upperCase.indexOf(el);
    return upperCase[(idx + 13) % 26];
  } else if (lowerCase.includes(el)) {
    const idx = lowerCase.indexOf(el);
    return lowerCase[(idx + 13) % 26];
  } else {
    return el;
  }
});

console.log(result.join(""));
