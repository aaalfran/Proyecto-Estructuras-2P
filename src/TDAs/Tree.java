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
public class Tree<E> {

    private TreeNode<E> root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public Tree(E contenido) {
        this.root = new TreeNode<>(contenido);
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        if (!this.isEmpty()) {
            return root.getChildren() == null;
        }
        return false;

    }

    public void remove(Tree<E> child) {
        for (int i = 0; i < this.root.getChildren().size(); i++) {
            Tree t = this.root.getChildren().get(i);
            if (t.equals(child)) {
                this.root.getChildren().remove(child);

            }
        }
    }

    
}
