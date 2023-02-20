const input =require("fs").readFileSync(0).toString().trim().split("\n");

const T = Number(input.shift());
let result = [];
for (let i = 0; i < T; i += 1) {
  const [M, N, K] = input.shift().split(" ").map(Number);
  const board = new Array(N).fill(0).map(el => new Array(M).fill(0));
  for (let j = 0; j < K; j += 1) {
    const [y, x] = input.shift().split(" ").map(Number);
    board[x][y] = 1;
  }

  const dx = [1, 0, -1, 0];
  const dy = [0, 1, -0, -1];
  const vis = new Array(N).fill(0).map(el => new Array(M).fill(0));
  let count = 0;
  for (let k = 0; k < N; k += 1) {
    for (let l = 0; l < M; l += 1) {
      if (board[k][l] === 0 || vis[k][l] === 1) continue;
      const queue = [];
      queue.push([k, l]);
      let head = 0;
      let tail = queue.length;
      count += 1;
      while (tail - head !== 0) {
        const [cur_x, cur_y] = queue[head];
        head += 1;
        for (let dir = 0; dir < 4; dir += 1) {
          const [nx, ny] = [cur_x + dx[dir], cur_y + dy[dir]];
          if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
          if (board[nx][ny] === 0 || vis[nx][ny] === 1) continue;
          queue.push([nx, ny]);
          tail += 1;
          vis[nx][ny] = 1;
        }
      }
    }
  }
  result.push(count);
}
console.log(result.join("\n"));
