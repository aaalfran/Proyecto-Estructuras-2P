/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author moise
 */
public class TreeNode<E> {
   private E content; 
   private LinkedList<Tree> children;

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public LinkedList<Tree> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<Tree> children) {
        this.children = children;
    }
    
   
}
