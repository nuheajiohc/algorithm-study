 const [firstLine, ...picture] = require("fs").readFileSync(0).toString().trim().split("\n");

const [n, m] = firstLine.split(" ").map(Number);
const board = picture.map(el => el.split(" "));
const vis = board.map(el => [...el].fill(0));

const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
let num = 0;
let max = 0;

for (let i = 0; i < n; i += 1) {
  for (let j = 0; j < m; j += 1) {
    if (vis[i][j] || board[i][j] === "0") continue;
    const queue = [];
    vis[i][j] = 1;
    queue.push([i, j]);
    let head = 0;
    let tail = 1;
    let area = 0;
    num += 1;
    while (tail - head !== 0) {
      area += 1;
      const [cur_x, cur_y] = queue[head];
      head += 1;
      for (let dir = 0; dir < 4; dir += 1) {
        const [nx, ny] = [cur_x + dx[dir], cur_y + dy[dir]];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (vis[nx][ny] || board[nx][ny] === "0") continue;
        vis[nx][ny] = 1;
        queue.push([nx, ny]);
        tail += 1;
      }
    }
    if (max < area) max = area;
  }
}

console.log(num + "\n" + max);