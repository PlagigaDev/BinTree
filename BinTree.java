import java.util.ArrayList;
import java.util.List;

//made by Ben Altmann

public class BinTree {
  private int content;
  private BinTree left;
  private BinTree right;

  public BinTree() {
    this.content = 0;
    this.left = null;
    this.right = null;
  }

  public BinTree createLeaf(int value){ //creates a new leaf on the current node
    BinTree newTree = new BinTree();
       newTree.set(value);
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
    if (this.isEmpty()) {
       this.content = value;
       return;    
    }
    if (value > this.content) {
      if (this.right == null) {
       this.right = createLeaf(value);
       return;
      }
      this.right.add(value);
    } else{
      if (this.left == null) {
        this.left = createLeaf(value);
        return;
      }
      this.left.add(value);
    }
  }
  
  public int getByAdress(String address){
    BinTree help = this; 
    while(true){
      if (address == ""){
        return help.get();
      }
      else if(help == null){
        return 0;
      }
      if(address.charAt(0) == 'l'){
        help = help.left;
      }
      else if(address.charAt(0) == 'r'){
        help = help.right;
      }
      else{
        return 0;
      }
      address = address.substring(1);
    }
    }
  
  public int[] getAll(){
    List<Integer> inputList = new ArrayList<>();
    inputList.add(this.content);
    if (this.left != null){

    }
    if (this.right != null){

    }
    return inputList.toArray();
  }

  public List<Integer> getAll(List inputList){
    inputList.add(this.content);
    if (this.left != null){
      
    }
    if (this.right != null){

    }
    return inputList;
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