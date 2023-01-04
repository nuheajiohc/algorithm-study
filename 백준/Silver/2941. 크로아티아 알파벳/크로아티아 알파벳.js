let input = require("fs").readFileSync(0).toString().trim();
if (input.includes("c=")) {
    input = input.replaceAll("c=", "a");
}
if (input.includes("c-")) {
    input = input.replaceAll("c-", "a");
}
if (input.includes("dz=")) {
    input = input.replaceAll("dz=", "a");
}
if (input.includes("z=")) {
    input = input.replaceAll("z=", "a");
}
if (input.includes("d-")) {
    input = input.replaceAll("d-", "a");
}
if (input.includes("nj")) {
    input = input.replaceAll("nj", "a");
}
if (input.includes("lj")) {
    input = input.replaceAll("lj", "a");
}
if (input.includes("s=")) {
    input = input.replaceAll("s=", "a");
}
console.log(input.length);