package com.leetcode.code38;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-08<p>
// 通知所有人的时间
//给一个公司的组织架构（有根树），每个老板只能向自己的直接下属传递信息，且不同老板花费的时间不同
//问大老板发出一个通知后，最短需要多长时间，所有员工才能全部收到这个通知。
//-------------------------------------------------------

public class NoticeAllPeople {

    public static int getMinTime(MemberNode currentNode) {
        if (currentNode == null || currentNode.getChildNodeList() == null || currentNode.getChildNodeList().size() == 0) {
            System.out.println("===>当前节点编号为"+currentNode.getId()+"直接返回");
            return 0;
        }
        int minTime=0;

        for (int i = 0; i < currentNode.childNodeList.size(); i++) {
            System.out.println("===>当前节点:"+currentNode.childNodeList.get(i).getId());

            int currentNodeWeight = currentNode.getWeightMap().get(currentNode.childNodeList.get(i));

            System.out.println("===>当前节点权重值:"+currentNodeWeight);


            int finalWeight = currentNodeWeight + getMinTime(currentNode.childNodeList.get(i));

            System.out.println("===>当前节点计算值:"+finalWeight);

            if (finalWeight >= minTime) {
                minTime = finalWeight;
            }

            System.out.println("===>第一个节点结束轮询minTime="+minTime+"=====================>\n\n\n\n");
        }
        return minTime;
    }

    public static void main(String[] args) {
        MemberNode sixNode = getSixNode();

        MemberNode twoNode = getTwoNode(sixNode);

        MemberNode threeNode = getThreeNode();

        MemberNode fourNode = getFourNode();

        MemberNode rootNode = getRootNode(twoNode, threeNode, fourNode);

        int result = getMinTime(rootNode);
        System.out.println("===>" + result);
    }

    private static MemberNode getRootNode(MemberNode twoNode, MemberNode threeNode, MemberNode fourNode) {

        List<MemberNode> childList = new ArrayList<>(3);
        childList.add(twoNode);
        childList.add(threeNode);
        childList.add(fourNode);


        Map<MemberNode, Integer> weightMap = new HashMap<>(3);
        weightMap.put(twoNode, 1);
        weightMap.put(threeNode, 3);
        weightMap.put(fourNode, 3);

        return new MemberNode("1", childList, weightMap);
    }

    private static MemberNode getFourNode() {

        MemberNode eightNode = new MemberNode("8");

        List<MemberNode> childList = new ArrayList<>(1);
        childList.add(eightNode);

        Map<MemberNode, Integer> weightMap = new HashMap<>(1);
        weightMap.put(eightNode, 6);

        return new MemberNode("4", childList, weightMap);
    }

    private static MemberNode getThreeNode() {
        MemberNode sevenNode = new MemberNode("7");

        List<MemberNode> childList = new ArrayList<>(2);
        childList.add(sevenNode);

        Map<MemberNode, Integer> weightMap = new HashMap<>(1);
        weightMap.put(sevenNode, 1);

        return new MemberNode("3", childList, weightMap);
    }

    private static MemberNode getTwoNode(MemberNode sixNode) {
        MemberNode fiveNode = new MemberNode("5");

        List<MemberNode> childList = new ArrayList<>(2);
        childList.add(fiveNode);
        childList.add(sixNode);

        Map<MemberNode, Integer> weightMap = new HashMap<>(2);
        weightMap.put(fiveNode, 2);
        weightMap.put(sixNode, 4);

        return new MemberNode("2", childList, weightMap);
    }

    private static MemberNode getSixNode() {

        MemberNode nineNode = new MemberNode("9");
        List<MemberNode> nineNodeChild = new ArrayList<>(1);
        nineNodeChild.add(nineNode);

        Map<MemberNode, Integer> nineWeightMap = new HashMap<>(1);
        nineWeightMap.put(nineNode, 2);
        return new MemberNode("6", nineNodeChild, nineWeightMap);
    }

    public static class MemberNode {

        /**
         * 当前节点id号,id号不重复
         */
        private String id;

        /**
         * 子孩子
         */
        private List<MemberNode> childNodeList;

        /**
         * 到每个子孩子的权重
         * <p>
         * Key:子孩子编号id
         * Value:到子孩子的权重
         * </>
         */
        private Map<MemberNode, Integer> weightMap;

        public MemberNode(String id, List<MemberNode> childNodeList, Map<MemberNode, Integer> weightMap) {
            this.id = id;
            this.childNodeList = childNodeList;
            this.weightMap = weightMap;
        }

        public MemberNode(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<MemberNode> getChildNodeList() {
            return childNodeList;
        }

        public void setChildNodeList(List<MemberNode> childNodeList) {
            this.childNodeList = childNodeList;
        }

        public Map<MemberNode, Integer> getWeightMap() {
            return weightMap;
        }

        public void setWeightMap(Map<MemberNode, Integer> weightMap) {
            this.weightMap = weightMap;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof MemberNode)) {
                return false;
            }
            MemberNode that = (MemberNode) o;
            return Objects.equals(getId(), that.getId()) &&
                    Objects.equals(getChildNodeList(), that.getChildNodeList()) &&
                    Objects.equals(getWeightMap(), that.getWeightMap());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getChildNodeList(), getWeightMap());
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MemberNode{");
            sb.append("id=").append(id);
            sb.append(", childNodeList=").append(childNodeList);
            sb.append(", weightMap=").append(weightMap);
            sb.append('}');
            return sb.toString();
        }
    }
}