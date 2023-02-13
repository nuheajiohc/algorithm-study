const [firstLine, ...square] = require("fs").readFileSync(0).toString().trim().split("\n");
const [M, N] = firstLine.split(" ").map(Number);
const board = square.map(el => el.split(" ").map(Number));
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
const queue = [];
let result = 0;
for (let i = 0; i < N; i += 1) {
  for (let j = 0; j < M; j += 1) {
    if (board[i][j] !== 1) continue;
    queue.push([i, j]);
  }
}

let head = 0;
let tail = queue.length;
while (tail - head !== 0) {
  const [cur_x, cur_y] = queue[head];
  head += 1;
  for (let dir = 0; dir < 4; dir += 1) {
    const [nx, ny] = [cur_x + dx[dir], cur_y + dy[dir]];
    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
    if (board[nx][ny]) continue;
    queue.push([nx, ny]);
    tail += 1;
    board[nx][ny] = board[cur_x][cur_y] + 1;
  }
}
for (let i = 0; i < N; i += 1) {
  for (let j = 0; j < M; j += 1) {
    if (board[i][j] === 0) {
      console.log(-1);
      return 0;
    }
    result = Math.max(result, board[i][j]);
  }
}
console.log(result - 1);