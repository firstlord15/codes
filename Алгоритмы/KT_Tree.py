class BinaryTree:
    def __init__(self, rootObj):
        self.key = rootObj
        self.leftChild = None
        self.rightChild = None

    def insertLeft(self, newNode):
        if self.leftChild is None:
            self.leftChild = BinaryTree(newNode)
        else:
            t = BinaryTree(newNode)
            t.leftChild = self.leftChild
            self.leftChild = t

    def insertRight(self, newNode):
        if self.rightChild is None:
            self.rightChild = BinaryTree(newNode)
        else:
            t = BinaryTree(newNode)
            t.rightChild = self.rightChild
            self.rightChild = t

    def getLeftChild(self):
        return self.leftChild

    def getRightChild(self):
        return self.rightChild

    def setRootVal(self, obj):
        self.key = obj

    def getRootVal(self):
        return self.key


def preorder(tree):
    if tree:
        print(tree.getRootVal())
        preorder(tree.getLeftChild())
        preorder(tree.getRightChild())


def countNodes(Tree):
    if Tree is None:
        return 0
    else:
        leftCount = countNodes(Tree.getLeftChild())
        RightCount = countNodes(Tree.getRightChild())
        return 1 + leftCount + RightCount


def countNodesAtLevel(tree, level=0):
    if tree is None:
        return 0
    elif level == 0:
        print(tree.getRootVal())
        return 1
    else:
        left_count = countNodesAtLevel(tree.getLeftChild(), level - 1)
        right_count = countNodesAtLevel(tree.getRightChild(), level - 1)
        return left_count + right_count


def countLeaves(tree):
    if tree is None:
        return 0
    elif tree.getLeftChild() is None and tree.getRightChild() is None:
        return 1
    else:
        return countLeaves(tree.getLeftChild()) + countLeaves(tree.getRightChild())


def find_max(Tree):
    if Tree is None:
        return 0
    elif Tree.getLeftChild() is None and Tree.getRightChild() is None:
        return Tree.getRootVal()
    else:
        left_max = find_max(Tree.getLeftChild())
        right_max = find_max(Tree.getRightChild())
        if not left_max is None and not right_max is None:
            return max(left_max, right_max)
        return 0


tree = BinaryTree(10)
tree.insertLeft(1)
tree.insertRight(2)
tree.getRightChild().insertRight(64)
tree.getRightChild().insertLeft(9)
tree.getRightChild().getRightChild().insertRight(1)
tree.getLeftChild().insertRight(12)
tree.getLeftChild().insertLeft(8)
print(find_max(tree))
