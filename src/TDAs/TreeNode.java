/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author moise
 * @param <E>
 */
public class TreeNode<E> {
   private E content; 
   private LinkedList<Tree<E>> children;

    public TreeNode(E content) {
        this.content = content;
        this.children = new LinkedList<>();
    }
    
   
    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public LinkedList<Tree<E>> getChildren() {
        return children;
    }

    public void addChild(E content){
        Tree<E> t= new Tree(content);
        this.children.addLast(t);
    
    }

    public void setChildren(LinkedList<Tree<E>> children) {
        this.children = children;
    }
     public void addChild(Tree<E> t){
        this.children.addLast(t);
    
    }
   
    
}
