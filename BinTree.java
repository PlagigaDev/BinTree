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

  private int[] copyArray(int[] original, int size){
    int[] newArr = new int[size];
    int duration = ((original.length>size) ? size : original.length);

    for(int i = 0; i<duration; i++){
      newArr[i] = original[i];
    }

    return newArr;
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
    } else if(value < this.content){
      if (this.left == null) {
        this.left = createLeaf(value);
        return;
      }
      this.left.add(value);
    }
  }
  
  public int getByAdress(String address){ // gives the number given at a special address
    BinTree help = this; 
    while(true){
      if(help == null){
        return 0;
      }
      if (address == ""){
        return help.get();
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
  
  public int[] getAll(){// gets all the values in order from smallest to largest
    int[] arr = new int[0];
    if (this.left != null){
      arr = this.left.getAll(arr);
    }
    arr = copyArray(arr, arr.length+1);
    arr[arr.length-1] = this.content;
    if(this.right != null){
      arr = this.right.getAll(arr);
    }
    return arr;

  }

  public int[] getAll(int[] arr){ // just takes an in an int array for the output
    if (this.left != null){
      arr = this.left.getAll(arr);
    }
    arr = copyArray(arr, arr.length+1);
    arr[arr.length-1] = this.content;
    if(this.right != null){
      arr = this.right.getAll(arr);
    }
    return arr;
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