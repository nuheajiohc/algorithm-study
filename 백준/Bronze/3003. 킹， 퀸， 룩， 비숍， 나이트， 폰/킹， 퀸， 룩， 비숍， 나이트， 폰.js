const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().split(" ");

const a = parseInt(input[0]);
const b = parseInt(input[1]);
const c = parseInt(input[2]);
const d = parseInt(input[3]);
const e = parseInt(input[4]);
const f = parseInt(input[5]);

const king = 1;
const queen = 1;
const rook = 2
const bishop = 2;
const knight = 2;
const pawn = 8;

console.log(king-a,queen-b,rook-c,bishop-d,knight-e,pawn-f);

