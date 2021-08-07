/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author moise
 * @param <T>
 */
public class TreeNode<T> {
   private T content; 
   private LinkedList<Tree> children;

    public TreeNode(T content) {
        this.content = content;
        this.children = new LinkedList<>();
    }
    
   
    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public LinkedList<Tree> getChildren() {
        return children;
    }

    public void add(T content){
        Tree t= new Tree(content);
        this.children.addLast(t);
    
    }
     public void add(Tree t){
        this.children.addLast(t);
    
    }
    public void setFather(LinkedList<Tree> children) {
        for (int i = 0; i < children.size(); i++) {
             Tree t = children.get(i);
             t.setRoot(this);
        }
    }
    
}
