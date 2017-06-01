package com.mytest.FastJson;

public class Node {

    private String id;
    private String pId;
    private String name;
    private boolean open;

    private Tree tree;

    public Node(String id, String pId, String name, boolean open, Tree tree) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.open = open;
        this.tree = tree;
    }

    public Node() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

}