package com.example.myapplication;

import java.util.LinkedList;
import java.util.Queue;

public class GRH {

    static class Graph {
        int V;
        LinkedList<Vertex> adjList[];

        Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V];

            for (int i = 0; i < V; ++i) {
                adjList[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge (Graph graph, int src, int dest, int weight) {
        graph.adjList[src].add(new Vertex(dest, weight));
        graph.adjList[dest].add(new Vertex(src, weight));
    }

    static void solve (Graph graph, int src, int dest, LineView mLineView, int h, int w, Node nodes[]) {
        int parent[] = new int[graph.V];
        BelmanFord(graph, src, parent);

        int act = parent[dest];
        mLineView.addPoint(nodes[dest].x, nodes[dest].y, h, w);

        while (parent[act] != -1) {
            mLineView.addPoint(nodes[act].x, nodes[act].y, h, w);
            mLineView.addPoint(nodes[act].x, nodes[act].y, h, w);
            act = parent[act];
        }

        mLineView.addPoint(nodes[src].x, nodes[src].y, h, w);

        mLineView.draw();
    }

    static void BelmanFord (Graph graph, int src, int parent[]) {
        int cost[] = new int[graph.V];
        int visited[] = new int[graph.V];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = 1;
        parent[src] = -1;
        queue.add(src);

        while (!queue.isEmpty()) {
            int act = queue.poll();
            for (Vertex v : graph.adjList[act]) {
                if (visited[v.id] == 0 || cost[act] + v.w < cost[v.id]) {
                    cost[v.id] = cost[act] + v.w;
                    visited[v.id] = 1;
                    parent[v.id] = act;
                    queue.add(v.id);
                }
            }
        }
    }
}
