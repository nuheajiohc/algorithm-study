const [N, ...input] = require("fs").readFileSync(0).toString().trim().split("\n");
const area = input.map(el => el.split(""));
const area1 = input.map(el => el.replaceAll("R", "G").split(""));
const result = [];
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];
person(area);
person(area1);
function person(area) {
  const vis = input.map(el => el.split("").fill(0));
  let count = 0;
  for (let i = 0; i < Number(N); i += 1) {
    for (let j = 0; j < Number(N); j += 1) {
      if (vis[i][j] === 1) continue;
      vis[i][j] = 1;
      const queue = [[i, j]];
      let head = 0;
      let tail = queue.length;
      count += 1;
      const cur_color = area[i][j];
      while (tail - head !== 0) {
        const [cur_x, cur_y] = queue[head];
        head += 1;
        for (let dir = 0; dir < 4; dir += 1) {
          const [nx, ny] = [cur_x + dx[dir], cur_y + dy[dir]];
          if (nx < 0 || ny < 0 || nx >= Number(N) || ny >= Number(N)) continue;
          if (vis[nx][ny] || area[nx][ny] !== cur_color) continue;
          queue.push([nx, ny]);
          vis[nx][ny] = 1;
          tail += 1;
        }
      }
    }
  }
  result.push(count);
}

console.log(result.join(" "));
