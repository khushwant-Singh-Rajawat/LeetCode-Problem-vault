import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        buildString(root, sb);

        return sb.toString();
    }

    void buildString(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    public TreeNode deserialize(String data) {

        Queue<String> queue =
            new LinkedList<>(Arrays.asList(data.split(",")));

        return buildTree(queue);
    }

    TreeNode buildTree(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }
}