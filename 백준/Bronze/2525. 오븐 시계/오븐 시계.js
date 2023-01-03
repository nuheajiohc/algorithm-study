const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const current = input[0].split(" ");

const h = parseInt(current[0]);
const m = parseInt(current[1]);

const sum_m = (h*60) + m + parseInt(input[1]);
const new_h = parseInt((sum_m/60)%24);
const new_m = sum_m%60;

console.log(new_h,new_m);