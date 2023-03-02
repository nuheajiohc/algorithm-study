const input = require("fs").readFileSync(0).toString().trim().split("\n");
a: for (let i = 0; i < Number(input[0]); i += 1) {
  let [I, cur_position, arrival_position] = input.slice(1 + 3 * i, 3 * i + 4);
  I = Number(I);
  const chessBoard = new Array(I).fill(0).map(() => new Array(I).fill(-1));
  const [cur_x, cur_y] = cur_position.split(" ").map(Number);
  const [arrival_x, arrival_y] = arrival_position.split(" ").map(Number);
  const dx = [1, 1, 2, 2, -1, -1, -2, -2];
  const dy = [-2, 2, -1, 1, 2, -2, -1, 1];
  const queue = [];
  chessBoard[cur_x][cur_y] = 0;
  if (cur_x === arrival_x && cur_y === arrival_y) {
    console.log(0);
    continue a;
  }

  for (let dir = 0; dir < 8; dir += 1) {
    const [nx, ny] = [cur_x + dx[dir], cur_y + dy[dir]];
    if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
    queue.push([nx, ny]);
    chessBoard[nx][ny] = 1;
    if (nx === arrival_x && ny === arrival_y) {
      console.log(chessBoard[nx][ny]);
      continue a;
    }
  }

  let head = 0;
  let tail = queue.length;
  while (tail - head !== 0) {
    const [x, y] = queue[head];
    head += 1;
    for (let dir = 0; dir < 8; dir += 1) {
      const [nx, ny] = [x + dx[dir], y + dy[dir]];
      if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
      if (chessBoard[nx][ny] > 0) continue;
      chessBoard[nx][ny] = chessBoard[x][y] + 1;
      if (nx === arrival_x && ny === arrival_y) {
        console.log(chessBoard[nx][ny]);
        continue a;
      }
      queue.push([nx, ny]);
      tail += 1;
    }
  }
}
