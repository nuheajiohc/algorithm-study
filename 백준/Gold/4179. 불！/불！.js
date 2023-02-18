const [rc, ...input] = require("fs").readFileSync(0).toString().trim().split("\n");


const [R, C] = rc.split(" ").map(Number);
const board = input.map(el => el.split(""));
const pos = input.map(el => el.split(""));
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
const j_pos = [];
const f_pos = [];
for (let i = 0; i < R; i += 1) {
  for (let j = 0; j < C; j += 1) {
    if (board[i][j] === "J") {
      j_pos.push([i, j]);
      continue;
    }
    if (board[i][j] === "F") {
      f_pos.push([i, j]);
      pos[i][j] = 0;
      continue;
    }
  }
}

let j_head = 0;
let j_tail = j_pos.length;
let f_head = 0;
let f_tail = f_pos.length;

while (f_tail - f_head !== 0) {
  const [cur_X, cur_Y] = f_pos[f_head];
  f_head += 1;
  for (let dir = 0; dir < 4; dir += 1) {
    const [nx, ny] = [cur_X + dx[dir], cur_Y + dy[dir]];
    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
    if (board[nx][ny] === "#" || pos[nx][ny] >= 0) continue;
    pos[nx][ny] = pos[cur_X][cur_Y] + 1;
    f_pos.push([nx, ny]);
    f_tail += 1;
  }
}
pos[j_pos[j_head][0]][j_pos[j_head][1]] = 0;
while (j_tail - j_head !== 0) {
  const [cur_X, cur_Y] = j_pos[j_head];
  j_head += 1;
  for (let dir = 0; dir < 4; dir += 1) {
    const [nx, ny] = [cur_X + dx[dir], cur_Y + dy[dir]];
    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
      console.log(pos[cur_X][cur_Y] + 1);
      return;
    }
    if (board[nx][ny] === "#") continue;
    if (pos[cur_X][cur_Y] + 1 >= pos[nx][ny]) continue;
    pos[nx][ny] = pos[cur_X][cur_Y] + 1;
    j_pos.push([nx, ny]);
    j_tail += 1;
  }
}

console.log("IMPOSSIBLE");
