package sayantan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeExample {

	public static Node<Integer> LCA(Node<Integer> root, int n1, int n2) {
		if (root == null)
			return root;
		if (root.getData() == n1 || root.getData() == n2)
			return root;

		Node<Integer> left = LCA(root.getLeft(), n1, n2);
		Node<Integer> right = LCA(root.getRight(), n1, n2);

		if (left != null && right != null)
			return root;
		if (left != null)
			return LCA(root.getLeft(), n1, n2);
		else
			return LCA(root.getRight(), n1, n2);
	}

	// Returns level of key k if it is present in
	// tree, otherwise returns -1
	public static int findLevel(Node<Integer> root, int a, int level) {
		if (root == null)
			return -1;
		if (root.getData() == a)
			return level;
		int left = findLevel(root.getLeft(), a, level + 1);
		if (left == -1)
			return findLevel(root.getRight(), a, level + 1);
		return left;
	}

	public static int findDistance(Node<Integer> root, int a, int b) {
		Node<Integer> lca = LCA(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		Node<Integer> root = null;

		Scanner scanner = new Scanner(System.in);
		int totalNodes = scanner.nextInt();

		List<Integer>numbers = new ArrayList<>();

		for (int i = 0 ; i< (totalNodes-1) * 2; i += 2) {

			int parentNode = scanner.nextInt();
			int childNode = scanner.nextInt();

			if (root == null) {
				root = new Node<>(parentNode);
			}

			root.addChild(new Node<Integer>(parentNode), new Node<Integer>(childNode));
			
			if(!numbers.contains(parentNode)) {
				numbers.add(parentNode);
			}
			
			if(!numbers.contains(childNode)) {
				numbers.add(childNode);
			}
		}

		scanner.close();
		
		printTree(root, " ");

		for (int i = 0; i < numbers.size(); i++) {

			int maxDistance = 0;

			Node<Integer> rootNode = root.searchNode(new Node<Integer>(numbers.get(i)));

			for (int j = 0; j < numbers.size(); j++) {

				for (int k = 0; k < numbers.size(); k++) {

					int distance = findDistance(rootNode, numbers.get(j), numbers.get(k));

					if (distance > maxDistance) {
						maxDistance = distance;
					}

				}
			}

			System.out.print(maxDistance + " ");
		}
	}

	private static <T> void printTree(Node<T> node, String appender) {

		if (node == null)
			return;

		System.out.println(appender + node.getData());
		printTree(node.getLeft(), appender + appender);
		printTree(node.getRight(), appender + appender);
	}
}
