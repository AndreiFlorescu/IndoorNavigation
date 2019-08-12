package com.example.myapplication;

import java.util.HashMap;
import java.util.Map;

public class BuildingDemo {

    static public Map<String, Integer> Rooms = new HashMap<>();
    static public Map<String, Integer> Floor = new HashMap<>();
    static public Node nodes[] = new Node[36];
    static public GRH.Graph graph = new GRH.Graph(36);
    public int startPoint[] = new int[5];

    BuildingDemo () {

        startPoint[0] = 26;
        startPoint[3] = 0;

        Rooms.put("support", 3);
        Rooms.put("open office 1", 4);
        Rooms.put("open office 2", 7);
        Rooms.put("office c", 6);
        Rooms.put("copy center", 8);
        Rooms.put("conference", 9);
        Rooms.put("reception", 12);
        Rooms.put("Office B", 15);
        Rooms.put("office a", 16);
        Rooms.put("waiting zone", 19);
        Rooms.put("kitchen", 21);
        Rooms.put("cafe lounge", 22);
        Rooms.put("bathroom", 25);

        Rooms.put("Mr. Ab", 3);
        Rooms.put("elevator", 31);
        Rooms.put("Office 5", 35);

        Floor.put("support", 3);
        Floor.put("open office 1", 3);
        Floor.put("open office 2", 3);
        Floor.put("office c", 3);
        Floor.put("copy center", 3);
        Floor.put("conference", 3);
        Floor.put("reception", 3);
        Floor.put("office a", 3);
        Floor.put("Office B", 3);
        Floor.put("waiting zone", 3);
        Floor.put("kitchen", 3);
        Floor.put("cafe lounge", 3);
        Floor.put("bathroom", 3);

        Floor.put("Mr. Ab", 3);

        Floor.put("elevator", 0);
        Floor.put("Office 5", 0);


        nodes[0] = new Node(0.425, 0.695);
        nodes[1] = new Node(0.425, 0.46);
        nodes[2] = new Node(0.645, 0.46);
        nodes[3] = new Node(0.645, 0.68);
        nodes[4] = new Node(0.645, 0.30);
        nodes[5] = new Node(0.76, 0.46);
        nodes[6] = new Node(0.76, 0.68);
        nodes[7] = new Node(0.76, 0.33);
        nodes[8] = new Node(0.84, 0.46);
        nodes[9] = new Node(0.425, 0.32);
        nodes[10] = new Node(0.425, 0.41);
        nodes[11] = new Node(0.35, 0.46);
        nodes[12] = new Node(0.35, 0.48);
        nodes[13] = new Node(0.28, 0.41);
        nodes[14] = new Node(0.202, 0.41);
        nodes[15] = new Node(0.28, 0.32);
        nodes[16] = new Node(0.202, 0.32);
        nodes[17] = new Node(0.30, 0.41);
        nodes[18] = new Node(0.30, 0.565);
        nodes[19] = new Node(0.23, 0.565);
        nodes[20] = new Node(0.23, 0.72);
        nodes[21] = new Node(0.26, 0.72);
        nodes[22] = new Node(0.19, 0.72);
        nodes[23] = new Node(0.615, 0.46);
        nodes[24] = new Node(0.615, 0.52);
        nodes[25] = new Node(0.57, 0.52);

        nodes[26] = new Node(0.50, 0.10);
        nodes[27] = new Node(0.50, 0.30);
        nodes[28] = new Node(0.445, 0.30);
        nodes[29] = new Node(0.445, 0.38);
        nodes[30] = new Node(0.348, 0.38);
        nodes[31] = new Node(0.348, 0.41);
        nodes[32] = new Node(0.555, 0.30);
        nodes[33] = new Node(0.555, 0.38);
        nodes[34] = new Node(0.755, 0.38);
        nodes[35] = new Node(0.755, 0.32);

        GRH.addEdge(graph, 26, 27, 1);
        GRH.addEdge(graph, 27, 28, 1);
        GRH.addEdge(graph, 28, 29, 1);
        GRH.addEdge(graph, 29, 30, 1);
        GRH.addEdge(graph, 30, 31, 1);

        GRH.addEdge(graph, 27, 32, 1);
        GRH.addEdge(graph, 32, 33, 1);
        GRH.addEdge(graph, 33, 34, 1);
        GRH.addEdge(graph, 34, 35, 1);

        GRH.addEdge(graph, 0, 1, 1);

        GRH.addEdge(graph, 1, 23, 1);
        GRH.addEdge(graph, 1, 10, 1);
        GRH.addEdge(graph, 1, 11, 1);

        GRH.addEdge(graph, 2, 3, 7);
        GRH.addEdge(graph, 2, 4, 7);
        GRH.addEdge(graph, 2, 5, 7);

        GRH.addEdge(graph, 5, 6, 9);
        GRH.addEdge(graph, 5, 7, 31);
        GRH.addEdge(graph, 5, 8, 31);

        GRH.addEdge(graph, 10, 9, 25);
        GRH.addEdge(graph, 10, 17, 25);

        GRH.addEdge(graph, 11, 12, 25);

        GRH.addEdge(graph, 13, 14, 25);
        GRH.addEdge(graph, 13, 15, 25);

        GRH.addEdge(graph, 14, 16, 25);

        GRH.addEdge(graph, 17, 13, 25);
        GRH.addEdge(graph, 17, 18, 25);

        GRH.addEdge(graph, 18, 19, 25);

        GRH.addEdge(graph, 19, 20, 25);

        GRH.addEdge(graph, 20, 21, 25);
        GRH.addEdge(graph, 20, 22, 25);

        GRH.addEdge(graph, 23, 2, 7);
        GRH.addEdge(graph, 23, 24, 7);

        GRH.addEdge(graph, 24, 25, 7);
    }
}
