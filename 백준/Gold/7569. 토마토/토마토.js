const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [M, N, H] = input.shift().split(" ").map(Number);
const square = [];
let count = 0;
while (input.length) {
  const floor = input.splice(0, N).map(el => el.split(" ").map(Number));
  square.push(floor);
}
const dx = [1, 0, -1, 0, 0, 0];
const dy = [0, 1, 0, -1, 0, 0];
const dz = [0, 0, 0, 0, 1, -1];
const queue = [];
for (let i = 0; i < H; i += 1) {
  for (let j = 0; j < N; j += 1) {
    for (let k = 0; k < M; k += 1) {
      if (square[i][j][k] !== 1) {
        if (square[i][j][k] === -1) count += 1;
        continue;
      }
      queue.push([i, j, k]);
      count += 1;
    }
  }
}
let head = 0;
let tail = queue.length;
let result = 0;
while (tail - head !== 0) {
  const [cur_z, cur_x, cur_y] = queue[head];
  head += 1;
  for (let dir = 0; dir < 6; dir += 1) {
    const [nz, nx, ny] = [cur_z + dz[dir], cur_x + dx[dir], cur_y + dy[dir]];
    if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;
    if (square[nz][nx][ny]) continue;
    queue.push([nz, nx, ny]);
    tail += 1;
    square[nz][nx][ny] = square[cur_z][cur_x][cur_y] + 1;
    result = Math.max(square[nz][nx][ny], result);
    count += 1;
  }
}
if (count !== M * N * H) console.log(-1);
else console.log(result === 0 ? 0 : result - 1);
