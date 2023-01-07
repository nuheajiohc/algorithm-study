const input = require("fs").readFileSync(0).toString();

const ascii_code = input.codePointAt(0);
console.log(ascii_code);