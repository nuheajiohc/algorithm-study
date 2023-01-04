const input = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);
let asc = [1, 2, 3, 4, 5, 6, 7, 8];
let desc = asc.slice().reverse();

if (String(asc) == String(input)) {
    console.log("ascending");
} else if (String(desc) == String(input)) {
    console.log("descending");
} else {
    console.log("mixed");
}