const [T,...PSList] = require("fs").readFileSync(0).toString().trim().split("\n");
const result = PSList.map(el => {
  let tmp = el;
  while (1) {
    tmp = tmp.replace("()", "");
    if (tmp.length === 0) {
      return "YES";
    }
    if (!tmp.includes("()")) {
      return "NO";
    }
  }
});

console.log(result.join("\n"));
