
public class BinTree {
  private int content;
  public BinTree left;
  public BinTree right;
  public BinTree parent;

  public BinTree() {
    content = 0;
    left = null;
    right = null;
    parent = null;
  }

  public BinTree createLeaf(int value){ //creates a new leaf on the current node
    BinTree newTree = new BinTree();
       newTree.set(value);
       newTree.setParent(this);
       return newTree;
  }

  public BinTree findNode(int value){ //recursive call back to find a node by a given value and return it
    if (value == this.content) {
      return this;
    }
    if (value > this.content) {
      if (this.right != null) {
        return this.right.findNode(value);
      }
    } else{
      if (this.left != null) {
        return this.left.findNode(value);
      }
    }
    return null;
  }

  public void setParent(BinTree newParent){ // sets the parent of the node
    this.parent = newParent;
  }

  public int get() { // gets the content of the node
    return this.content;
  }

  public boolean isEmpty() { //checks if the node is empty
    return (this.content == 0);
  }

  public void set(int value) { // sets the value of the current node
    this.content = value;
  }

  public void add(int value) { // adds a new value to the tree
    if (value > this.content) {
      if (this.right == null) {
       this.right = createLeaf(value);
      }
      this.right.add(value);
    } else{
      if (this.left == null) {
        this.left = createLeaf(value);
      }
      this.left.add(value);
    }
  }

  public boolean search(int value) { // checks if a given value is a part of the tree
   return (this.findNode(value) != null);
  }

  /*public void delete(int value) // deletes a given value from the tree
  {
    BinTree treeToDelete = this.findNode(value);
    if (treeToDelete != null) {
    BinTree treeParent = treeToDelete.parent;
    if (treeToDelete.right == null && treeToDelete.left == null){
      if (treeToDelete.get() < treeParent.get()){
        treeParent.left = null;
      }
      else{
        treeParent.right = null;
      }
    }
    }
  }
  
  public void rightRotate(){ // does a right rotation
    
  }
  */

}
