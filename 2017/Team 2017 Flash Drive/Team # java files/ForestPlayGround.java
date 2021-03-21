/**
 * @author:   Mr. Allen
 *            2017 Wittry contest
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class ForestPlayGround 
{
    private String[] myTree;

    /*
     *   PreConditions
     *        tree is a valid represntation fo a binary tree
     *        tree != null
     *        tree.size() >= 0
     */
    public ForestPlayGround(String[] tree)
    {
        myTree = tree;
    }

    private boolean allowed(int i) {
        return i >= 0 && i < myTree.length && myTree[i] != null;
    }

    /*
     *    return the number of non null nodes in myTree
     */

    public int getNumNodes()
    {
        return (int) Arrays.stream(myTree).filter(Objects::nonNull).count();
    }

    /*
     *    A leaf is a node in the tree in which both children have 0 children.
     *    An empty tree contains NO leafs
     */
    public int getNumLeafs()
    {
        if (myTree == null)
            return 0;
        return getNumLeavesRecurse(0);
    }

    private int getNumLeavesRecurse(int i) {
        if (!allowed(i))
            return 0;
        if (!allowed(2 * i + 1) && !allowed(2 * i + 2))
            return 1;
        return getNumLeavesRecurse(2 * i + 1) + getNumLeavesRecurse(2 * i + 2);
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *
     *    returns:
     *        the right child of myTree[p]
     *        null if myTree[p] does not have a right child
     */
    public String getRightChild(int p)
    {
        var nextPos = 2 * p + 2;
        if (!allowed(nextPos))
            return null;
        return myTree[nextPos];
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *
     *    returns:
     *        the left child of myTree[p]
     *        null if myTree[p] does not have a left child
     */
    public String getLeftChild(int p)
    {
        var nextPos = 2 * p + 1;
        if (!allowed(nextPos))
            return null;
        return myTree[nextPos];
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *                    myTree[p] != null
     *
     *    returns:
     *        the parent of myTree[p]
     *        null if myTree[p] does not have a parent
     */
    public String getParent(int p)
    {
        var nextPos = (p - 1) / 2;
        if (!allowed(nextPos) || p == 0)
            return null;
        return myTree[nextPos];
    }

    /*
     *    Precondition:   0 <= p < myTree.length
     *                    myTree[p] != null
     *
     *    returns:
     *        the List of all ancestors (parent and their parent ans so on) of myTree[p]
     *        an empty List if myTree[p] does not have a parent
     */
    public List<String> getAncestors(int p)
    {
        List<String> ans = new ArrayList<String>();

        var nextPos = (p - 1) / 2;
        while(allowed(nextPos) && nextPos != 0) {
            ans.add(myTree[nextPos]);
            nextPos = (nextPos - 1) / 2;
        }
        ans.add(myTree[0]);

        return ans;
    }

    /*
     * Preconditions:
     *    myTree[p] != null
     *    0 <= p < myTree.length
     */
    public List<String> getDescendants(int p)
    {
        List<String> ans = new ArrayList<String>();

        ans.addAll(getDescendantsInt(2 * p + 1));
        ans.addAll(getDescendantsInt(2 * p + 2));

        return ans;
    }

    private List<String> getDescendantsInt(int p) {
        List<String> ans = new ArrayList<String>();

        if(!allowed(p))
            return ans;

        ans.add(myTree[p]);
        ans.addAll(getDescendantsInt(2 * p + 1));
        ans.addAll(getDescendantsInt(2 * p + 2));

        return ans;
    }

    /*
     *    In a complete binary tree every level, except possibly the last, is completely filled,
     *    and all nodes in the last level are as far left as possible.
     *    
     *    This implies that the end of the array may contain multiple nulls
     *                               and the array/tree may still be complete
     */
    public boolean isComplete()
    {
        boolean noNullsPast = false;
        for(int i = 0; i < myTree.length; ++i) {
            noNullsPast |= myTree[i] == null;
            if (noNullsPast && myTree[i] != null)
                return false;
        }

        return true;
    }

    /*
     *    A full binary tree is a tree in which every node in the tree has either 0 or 2 children.
     */
    public boolean isFull()
    {
        if (myTree == null || myTree.length == 0)
            return true;

        return isFullInt(0);
    }

    private boolean isFullInt(int p)
    {
        var a = getLeftChild(p) == null;
        var b = getRightChild(p) == null;
        if (a != b) // One child
            return false;
        if (getLeftChild(p) == null) // Bottom of tree (leaf)
            return true;

        return isFullInt(2 * p + 1) && isFullInt(2 * p + 2);
    }
}