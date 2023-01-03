const input = Number(require("fs").readFileSync(0).toString().trim());

const StarArr = ["*".repeat(input)];
let starline = '';
for (let i = 1; i < input; i++) {
    starline = `${" ".repeat(i)}${"*".repeat(input-i)}`;
    StarArr.unshift(starline);
    StarArr.push(starline);
}
console.log(StarArr.join("\n"));