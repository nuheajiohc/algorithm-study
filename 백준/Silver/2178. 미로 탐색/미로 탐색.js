const [firstLine, ...square] = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, M] = firstLine.split(" ").map(Number);
const board = square.map(row =>
  row
    .split("")
    .map(Number)
    .map(el => (el ? -1 : 0)),
);
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
board[0][0] = 1;
const queue = [];
queue.push([0, 0]);
let head = 0;
let tail = 1;
while (tail - head !== 0) {
  const [cur_x, cur_y] = queue[head];
  head += 1;
  for (let i = 0; i < 4; i += 1) {
    const [nx, ny] = [cur_x + dx[i], cur_y + dy[i]];
    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    if (board[nx][ny] >= 0) continue;
    queue.push([nx, ny]);
    tail += 1;
    board[nx][ny] = board[cur_x][cur_y] + 1;
  }
}

console.log(board[N - 1][M - 1]);
