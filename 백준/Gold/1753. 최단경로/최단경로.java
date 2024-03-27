import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		int K = sc.nextInt();
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		// 입력 받기
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			// 유향 그래프였다
			adjList[A].add(new Node(B, W)); // 인접리스트 노드 추가
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0; // 시작노드까지의 거리는 0
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.v] < now.w)
				continue; // 이미 처리된 노드면 skip

			for (Node next : adjList[now.v]) {
				int newDist = dist[now.v] + next.w;
				if (dist[next.v] > newDist) { // 거리가 갱신되는 경우
					dist[next.v] = newDist;
					pq.offer(new Node(next.v, newDist));
				}
			}
		}
	}
}
