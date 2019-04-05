#define _CRT_SECURE_NO_WARNINGS

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define SIZE 100
#define TRUE 1
#define FALSE 0

#define INF 10000 //경로가 없을경우 이 값으로 변경

int selected[SIZE]; // 선택된 정점의 정보 저장

int dist[SIZE];//최소 거리 정보들 저장

int quiz[SIZE][SIZE]; //배열

void prim(int s, int n);

int get_min_vertex(int n);


void main()
{
	

	FILE *fp;
	char buffer[100 * SIZE];
	char *ptr;
	int i = 0, j = 0;


	fp = fopen("./quiz.csv", "r");
	
	if (fp == NULL) {
		puts("file open failed");
		return;
	}
	for (i = 0; i < SIZE; i++)
	{
		fgets(buffer, 100 * SIZE, fp);
		ptr = strtok(buffer, ",");
		j = 0;

		while (ptr != NULL)
		{
			quiz[i][j] = atof(ptr);
			ptr = strtok(NULL, ",");
			j++;
		}
	}

	fclose(fp);
	

	prim(0, SIZE);

}


int get_min_vertex(n)// 최소 거리 값을 갖는 정점 반환
{
	int  v, i;

	for (i = 0; i < n; i++)
	{
		if (!selected[i]) {
			v = i; // 선택 되지 않은 정점을 저장 -> 사이클 방지
			break;
		}
	}

	for (i = 0; i < n; i++) // 위 for문에서 선택된 정점이 최소 거리를 가지는 지 판별
	{
		
			if (!selected[i] && (dist[i] < dist[v]))
			{
				v = i; // 더 적은 거리가 존재하면 해당 정점을 저장
			}
	}

	return(v); //최소거리 가지는 정점을 반환


}

void prim(s,n) //s는 시작 정점
{
	int cost_sum = 0; // 코스트 합

	int i, u, v,j;
	
	for (u = 0; u < n; u++)
	{
		dist[u] = INF; // 거리정보를 모두 초기화
		selected[u] = FALSE; // 선택 노드 정보 초기화
	}
	
	dist[s] = 0;// 시작 정점에서 시작정점은 0

	for (i = 0; i < n; i++)
	{
		u = get_min_vertex(n); // 리턴된 값을 최소 거리를 가지는 정점으로
		selected[u] = TRUE; // 정점을 사용했다는 표시


		if (dist[u] == INF) return;

		
		for (v = 0; v < n; v++)
		{
			if (quiz[u][v] != 0)
			{
				if (!selected[v]&& quiz[u][v] < dist[v])
				{
					dist[v] = quiz[u][v]; //dist값 변경
					
				}
			}
		
			if (s != u)  // 시작점이 선택점과 같지 않을때 
			{ 
				printf("%d to %d cost: %d \n", s, u, dist[u]); 
				cost_sum += dist[u];  //총 코스트 비용 합
				s = u;  //시작점을 변경
			}
		}
		

	}
	printf("total cost : %d\n", cost_sum);
	
}

