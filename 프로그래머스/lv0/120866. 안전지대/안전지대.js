function solution(board) {
    const n = board.length;
    const dx=[-1,-1,-1,0,0,1,1,1];
    const dy=[0,1,-1,1,-1,1,0,-1];
    const vis = [...board].map(el=>[...el].fill(0));
    const queue=[];
    for(let i=0;i<n;i+=1){
        for(let j=0;j<n;j+=1){
            if(board[i][j]!==1) continue;
            queue.push([i,j]);
            let head=0;
            let tail=queue.length;
            vis[i][j]=1;
            while(tail-head!==0){
                const [cur_x,cur_y]=queue[head];
                head+=1;
                for(let dir=0;dir<8;dir+=1){
                    const [nx,ny]=[cur_x+dx[dir],cur_y+dy[dir]];
                    if(nx<0||ny<0||nx>=n||ny>=n) continue;
                    vis[nx][ny]=1;
                }
            }
        }
    }
    let count=0;
    for(let i=0;i<n;i+=1){
        for(let j=0;j<n;j+=1){
            if(vis[i][j]===0) count+=1;
        }
    }
    return count;
}