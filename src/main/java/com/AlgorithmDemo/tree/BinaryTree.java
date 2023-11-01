 package com.AlgorithmDemo.tree;
import com.AlgorithmDemo.linear.queueDemo.Queue;
 public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中元素的个数
    public int size() {
        return N;
    }

    /*向树中添加元素key-value*/
    public void put(Key key, Value value){
         // 调用重载的方法
        root = put(this.root, key, value);
    }

    public Node put(Node x, Key key, Value value){
        //先设置根节点
        if (x==null){
            N++;
            return new Node(key, value, null, null);
        }
        /*如果x子树不为空,比较x结点的键和key的大小*/
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            // 如果大于x结点的键，则继续找x结点的右子树
            x.right=put(x.right, key, value);
        } else if (cmp<0) {
            //小于x则继续找x结点的左子树
            x.left=put(x.left, key, value);
        }else {
            // 如果相当则替换即可
            x.value = value;
        }
        return x;
    }

    // 查询树中指定key对应的value；
    public Value get(Key key){
        return get(root, key);
    }

    public Value get(Node x, Key key){
        if (x==null){
            return null;
        }

        // x不为空的情况下开始做对比操作
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            // 如果大于x结点的键，则继续找x结点的右子树
            return get(x.right, key);
        } else if (cmp<0) {
            //小于x则继续找x结点的左子树
            return get(x.left, key);
        }else {
            // 如果相当则替换即可
            return x.value;
        }
    }

    public void delete(Key key){
        delete(root, key);
    }

    public Node delete(Node x, Key key){
        if (x==null){
            return null;
        }


        /*先找到要删除的结点x,通过不断地递归调用，左子树或者右子树移动结点直到找到结点x的位置出现为止；
        * 也就是说输入的x.key=key(树中的结点key)*/
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            x.right=delete(x.right, key);
        } else if (cmp < 0) {
            x.left=delete(x.left, key);
        }else {
            // 找到了需要删除的结点x;
            N--;


            //这里是判断找到结点x后，查询结点左子树和右子树是否存在为null的情况，如果存在则直接返回对应子树的结点即可；
            if (x.right==null){
                return x.left;
            }
            if (x.left==null){
                return x.right;
            }


            // 找到右子树的最小结点所在位置
            Node minNode = x.right;
            while (minNode.left!=null){
                minNode = minNode.left;
            }

            // 删除右子树最小结点；
            Node n = x.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left=null;
                }else {
                    n=n.left;
                }
            }

            /*1.x结点的左子树成为minNode的左子树；
            * 2. x结点的右子树成为minNode右子树；
            * 3.x结点的父节点成为minNode父节点；
            * */
            minNode.left=x.left;
            minNode.right=x.right;
            x=minNode;
        }
        return x;
    }



    /*找到整个树的最小键*/
    public Key min(){
        return min(root).key;
    }

    public Node min(Node x){
        if (x==null){
            return null;
        }

        if (x.left !=null){
            return min(x.left);
        }else {
            return x;
        }

    }

    /*找到整个树的最大值*/
    public Key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if (x==null){
            return null;
        }

        if (x.right !=null){
            return max(x.right);
        }else {
            return x;
        }
    }

    /*树的遍历：
    * 1.前序遍历，中序遍历，后序遍历
    * 2.先获取到整个树中的所有键
    * */


    //获取整个树中所有的键, 前序遍历 :先根节点 →左子树→右子树
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }
     private void preErgodic(Node x, Queue<Key> keys){
        if (x==null){
            return;
        }
        keys.enqueue(x.key);
        if (x.left!=null){
            preErgodic(x.left, keys);
        }
        if (x.right!=null){
            preErgodic(x.right, keys);
        }
     }

     //获取整个树中所有的键, 中序遍历 :先左子树 →根结点→右子树
     public Queue<Key> midErgodic(){
         Queue<Key> keys = new Queue<>();
         midErgodic(root,keys);
         return keys;
     }
     private void midErgodic(Node x, Queue<Key> keys){
        if (x==null){
            return;
        }
        if (x.left!=null){
            midErgodic(x.left, keys);
        }
        keys.enqueue(x.key);
        if (x.right!=null){
            midErgodic(x.right, keys);
        }
     }


     //获取整个树中所有的键, 中序遍历 :先左子树 →右子树→根结点
     public Queue<Key> afterErgodic(){
         Queue<Key> keys = new Queue<>();
         afterErgodic(root,keys);
         return keys;
     }
     private void afterErgodic(Node x, Queue<Key> keys){
         if (x==null){
             return;
         }
         if (x.left!=null){
             afterErgodic(x.left, keys);
         }
         if (x.right!=null){
             afterErgodic(x.right, keys);
         }
         keys.enqueue(x.key);

     }

     /*层序遍历：
     * 1.获取当前结点的key;
     * 2.如果当前结点的左子结点不为空，则把左子结点放入到队列中；
     * 3.如果当前结点的右子结点不为空，则把右子结点放入到队列中；
     * */
     //使用层序遍历，获取整个树中所有的键
     public Queue<Key> layerErgodic(){
         // 定义两个队列， 分别存储键和树中的结点值；
         Queue<Key> keys = new Queue<>();
         Queue<Node> nodes = new Queue<>();

         nodes.enqueue(root);
         while (!nodes.isEmpty()){
             Node n = nodes.dequeue();
             keys.enqueue(n.key);
             if (n.left!=null){
                 nodes.enqueue(n.left);
             }
             if (n.right!=null){
                 nodes.enqueue(n.right);
             }

         }
         return keys;
     }

     /*计算最大深度问题*/
     public int maxDepth(){
         return maxDepth(root);
     }
     public int maxDepth(Node x){
         if (x==null) {
             return 0;
         }

         int max=0;
         int maxL=0;
         int maxR=0;
         if (x.left!=null){
             maxL = maxDepth(x.left);
         }
         if (x.right!=null){
             maxR = maxDepth(x.right);
         }
         //比较左子树最大深度和右子树最大深度，取较大值+1即可
         max = maxL>maxR ? maxL+1:maxR+1;
         return max;
     }
 }
