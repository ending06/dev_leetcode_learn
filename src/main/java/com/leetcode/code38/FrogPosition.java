package com.leetcode.code38;


import java.util.ArrayList;
import java.util.List;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-08<p>
//https://leetcode-cn.com/problems/frog-position-after-t-seconds/
//青蛙T秒跳到目的地的概率
//-------------------------------------------------------

public class FrogPosition {
    public static double frogPosition(int n, int[][] edges, int t, int target) {
        Node node = new Node(edges[0][0]);
        return getResult(node,0,1,t,target,edges);
    }


    private static double getResult(Node node,int current_time,double rate,int t,int target,int[][] edges){
        findChild(node,edges);

        if(current_time==t){
            if(node.getId()==target){
                return rate;
            }else{
                System.out.println("=========");
                return 0;
            }
        }
        double currentNodeRate = 0;

        if (node.getChildNode()==null||node.getChildNode().isEmpty()||node.getChildNode().size()==0) {
            getResult(node,current_time+1,rate,t,target,edges);
        }else{
            for(Node childNode:node.getChildNode()){
                double tempRate = 0;
                tempRate = getResult(childNode,current_time+1,rate*((double)1/node.getChildNode().size()),t,target,edges);

                System.out.println("当前Node==>>"+node.getId()+";;;;tempRate="+tempRate);
                currentNodeRate = currentNodeRate+tempRate;

                System.out.println("当前Node==>>"+node.getId()+";;;;currentNodeRate="+currentNodeRate);

            }
        }
        System.out.println("  AA==Node==>>"+node.getId()+";;;;currentNodeRate="+currentNodeRate);
        return currentNodeRate;
    }

    private static void findChild(Node node, int[][] edges) {
        List<Node> childNodeList = new ArrayList<>();
        for(int[] array:edges){
            if(array[0]==node.getId()){
                childNodeList.add(new Node(array[1]));
            }
        }
        node.setChildNode(childNodeList);
    }

    public static void main(String[] args) {
        int[][] init = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};

        double result = frogPosition(7,init,2,4);

        System.out.println("===>"+result);
    }

    private static class Node {
        private int id;

        List<Node> childNode;

        public Node(int id, List<Node> childNode) {
            this.id = id;
            this.childNode = childNode;
        }

        public Node(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Node> getChildNode() {
            return childNode;
        }

        public void setChildNode(List<Node> childNode) {
            this.childNode = childNode;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("id=").append(id);
            sb.append(", childNode=").append(childNode);
            sb.append('}');
            return sb.toString();
        }
    }
}