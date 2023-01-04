const input = require("fs").readFileSync(0).toString().trim().split("\n");
const area = new Array(101).fill(0).map(() => new Array(101).fill(0));
for (let i = 0; i < input.length; i++) {
    const Square = input[i].split(" ").map(a => +a);
    const firstX = Square[0];
    const firstY = Square[1];
    const secondX = Square[2];
    const secondY = Square[3];
    for (let j = firstX; j < secondX; j++) {
        for (let k = firstY; k < secondY; k++) {
            area[j][k] = 1;
        }
    }
}
let arr = [];
area.forEach(el => { arr = [...arr, ...el] });
console.log(arr.filter(el => el !== 0).length);