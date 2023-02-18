const [N, K] = require("fs").readFileSync(0).toString().trim().split(" ").map(Number);

const vis = new Array(100001).fill(-1);
const dx = [-1, +1, 2];
const queue = [N];
vis[N] = 0;
let head = 0;
let tail = queue.length;
if (N === K) {
  console.log(0);
  return;
}
while (tail - head !== 0) {
  const cur_x = queue[head];
  head += 1;
  for (let dir = 0; dir < 3; dir += 1) {
    let nx;
    if (dir === 2) {
      nx = cur_x * dx[dir];
    } else {
      nx = cur_x + dx[dir];
    }
    if (nx < 0 || nx > 100000) continue;
    if (vis[nx] !== -1) continue;
    queue.push(nx);
    vis[nx] = vis[cur_x] + 1;
    tail += 1;
    if (nx === K) {
      console.log(vis[nx]);
      return;
    }
  }
}
