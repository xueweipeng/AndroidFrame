package com.sogou.androidframe.algorithm

import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.ArrayList

/**
created by weapon on 2021/3/1
 */
object Solution {
    /**
     * 从上到下打印二叉树，每层输出列表，整体输出大列表
     * 示例：
    二叉树：[3,9,20,null,null,15,7],

    3
    / \
    9  20
    /  \
    15   7
    返回其层序遍历结果：

    [
    [3],
    [9,20],
    [15,7]
    ]

     */
    fun levelOrder(root: TreeNode?): List<List<Int>>? {
        if (root == null) return null
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        val res = ArrayList<Int>()
        queue.offer(root)
        var current = 1 //当前层需打印的节点数量
        var nextLevelCount = 0 //下一层需要打印的节点数量
        val retList = mutableListOf<List<Int>>()
        val levelList = mutableListOf<Int>()
        while (!queue.isEmpty()) {
            val node: TreeNode? = queue.poll()
            current--
            levelList.add(node?.value!!)
            res.add(node?.value!!)
            if (node.left != null) {
                queue.offer(node.left)
                nextLevelCount++
            }
            if (node.right != null) {
                queue.offer(node.right)
                nextLevelCount++
            }
            if (current == 0) {
                retList.add(levelList)
                levelList.clear()
                current = nextLevelCount
                nextLevelCount = 0
            }
        }

        return retList
    }

    fun preOrder(node: TreeNode?) {

    }

    //计算数组小和


    //数组中出现次数最多的元素


    //股票最大收益
    open fun getMaxProfit(prices: IntArray): Int {
        var i = 0
        var maxProfit = 0
        var peck = prices[0]
        var valley = prices[0]

        // 一次外循环，时间复杂度为 O(n),每次外循环能找到一组收益，（一个低谷和一个高峰）
        while (i < prices.size - 1) {
            //-------------------找本次的低谷值--------------------------
            while (i < prices.size - 1 && prices[i] >= prices[i + 1]) // 遇到比自己大的，继续往后走
                i++
            // 遇到比自己小的，退出循环，找到一个低谷值
            valley = prices[i]

            //-------------------找本次的峰值----------------------------
            while (i < prices.size - 1 && prices[i] <= prices[i + 1]) //遇到比自己小的，继续往后走
                i++
            //当遇到比自己大的，就退出循环，此时找到了一个峰值
            peck = prices[i]

            //单次收益值等于本次峰值-本次低谷值
            //累加每轮循环的收益
            maxProfit += peck - valley
        }
        return maxProfit
    }

    //线程问题（A启动BCD 并等待BCD运行结束继续运行）


    //回形查找数组最后一个点


    //二进制求和
    //字符串a = 1010
    //string b = 1011
    //
    //输出字符串
    //
    //public String add (String a, String b) {
    //	int len = 0;
    //	if (a.length <= b.length) {
    //		len = a.length;
    //	}
    //	char[] result = new char[b.length];
    //	for ( int i=len-1;i >=0; i --) {
    //		char ca = a.getcharat(i);
    //		char cb = b.getcharat(i);
    //		'0'
    //	}
    //}
    fun waitModel() {
        var atomicInteger =
            AtomicInteger(3)
        var t1 = Thread(Runnable {
            println("t1 start")
            atomicInteger.getAndDecrement()
        })
        var t2 = Thread(Runnable {
            println("t2 start")
            atomicInteger.getAndDecrement()
        })
        var t3 = Thread(Runnable {
            println("t3 start")
            try {
                Thread.sleep(300)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            atomicInteger.getAndDecrement()
        })
        var twait = Thread(Runnable {
            val s = System.currentTimeMillis()
            while (true) {
                if (atomicInteger.get() == 0) {
                    println("atomic finish")
                    break
                } else {
                    if (System.currentTimeMillis() - s > 200) {
                        println("timeout finish")
                        break
                    }
                }
            }
        })
        twait.start()
        t1.start()
        t2.start()
        t3.start()
    }


    fun main() {

    }
}