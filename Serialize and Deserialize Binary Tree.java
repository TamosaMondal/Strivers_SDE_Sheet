/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                res.append("# ");
                continue;
            }
            res.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        System.out.println(res.toString());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode>q=new LinkedList<>();
        String[] s=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        for(int i=1;i<s.length;i++){
            TreeNode parent=q.poll();
            if(!s[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(s[i]));
                parent.left=left;
                q.add(left);
            }
            if(!s[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(s[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
