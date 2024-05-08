#include <vector>
#include <iostream>
#include <stack>  
#include <cmath>   //max사용을 위한 헤더
#include<algorithm>  //sort사용을 위한 헤더
using namespace std;

vector<bool> visit(100000, false);    //방문한 곳을 표시하기 위한 배열
vector<int> computer[100000];     //컴퓨터의 관계를 나타낸 배열
vector<int> countComputer[100000];     //카운트해서 저장할 배열
vector<int>Compare;   //가장 큰 출발점만 저장해 오름차순 정렬할 배열

void dfs(int start, int *cnt) {
	visit[start] = true;  //방문한 곳 푯표시
	(*cnt)++;
	for (int i = 0; i < computer[start].size(); i++) {   
		int next = computer[start][i];
		if (!visit[next]) {     // 방문하지 않았다면 다시 dfs 호출
			dfs(next, cnt);
		}
	}
	
}

int main() {
	int N, M, i, A, B, cnt =0, maxcount =0;
	int* pcnt=&cnt;
	cin >> N >> M;

	for (i = 0; i < M; i++) {
		cin >> A >> B;
		computer[B].push_back(A);
	}

	for (i = 1; i <= N; i++) {
		*pcnt = 0;
		dfs(i, pcnt);         
		maxcount = max(maxcount, *pcnt);
		countComputer[*pcnt].push_back(i);     //카운트안에 출발점들 저장

		fill(visit.begin(), visit.end(), false);     //다시 방문한 곳 초기화
	}
	for (i = 0; i < countComputer[maxcount].size(); i++) {  //가장 큰 count를 가진 출발점만 따로 저장 (sort를 하기 위함)
		Compare.push_back(countComputer[maxcount][i]);
	}

	sort(Compare.begin(), Compare.end());  //오름 차순 정렬

	for (auto iter : Compare) {
		cout << iter << '\n';
	}


}