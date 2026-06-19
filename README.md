#  Data Structures & Algorithms (DSA)

A comprehensive Java Core application built completely from scratch to understand the core of Data Structures & Algorithms (DSA). 

### Data Structures Implemented:
* Linked List
* Stack
* Queue
* Binary Search Tree (BST)
* HashTables

## Core of Architectural Highlights & Mechanics

This project completely avoids using any of Java's built-in collections framework (`java.util.Stack`, `java.util.Queue`, etc.) to showcase pure logic of the data structures.

### 1. Custom Queue Implementation (`Queue.java`)
* Implements a standard dynamic **FIFO (First In, First Out)** data structure using custom linked nodes.
* Features `EnQueue(String x)` to add elements to the tail and `DeQueue()` to remove elements from the head safely.
* Used to store and maintain the correct order of parsed tokens and postfix expressions.

### 2. The Dual-Purpose Hybrid Stack Engine (`Stack.java`)
One of the most creative design decisions in this project is the engineering of a **Hybrid Stack** that independently processes completely different data categories under the same memory reference:
• **Token Operations (String-based):** Uses standard `push()`, `pop()`, and `top()` running on a regular dynamic `Node` linked-list structure to handle tracking operator precedence.
• **Abstract Syntax Tree Build-Suite (NodeT-based):** Integrates an auxiliary custom inner layout (`StackNode` & `Nodet`). Its specialized `pusht(Nodet x)` and `popt()` methods hold complete physical memory branches of the binary tree during execution. 

### 3. Expression Binary Search Tree (`ExpressionBST.java`)
• Built dynamically out of a postfix queue sequence using custom tree-pointer logic (`Nodet`).
• When an operator is encountered, the custom stack pops two consecutive sub-tree references (`left` and `right` nodes) and joins them under the operator node.
• Implements full pointer-recursive tree traversals: **Inorder**, **Preorder**, and **Postorder**.

### 4. Advanced Custom HashTable Map (`HashTable.java`)
Features a custom storage mechanism executing an absolute-modulo mapping strategy `Math.abs(key) % size` with a robust set of built-in **Collision Resolution** mechanics:
• **Open Addressing Methods:** Fully implements **Linear Probing**, **Quadratic Probing** (i^2 offset scanning), and **Double Hashing** (utilizing a dual-step strategy `7 - (key % size)`).
• **Closed Addressing (Separate Chaining):** Resolves collisions by using an array of Linked Lists, where items that hash to the same index are simply appended into a chain at that position.

##  System Features & Math Validations

1. **Tokenization Engine:** Robust scanning that drops white spaces, isolates multi-digit or decimal structures, routes negative numbers dynamically, and flags bad sequence markers (e.g., rejecting invalid float notations like `3.3.5`).
2. **Grammar & Precedence Safety:** Hardcoded syntax guardrails handling operator boundaries, runtime division-by-zero blocks, and nested parentheses checking.
3. **File I/O Interface (Bonus Suite):** Completely decoupled from plain console inputs; processes expression input from an external `input.txt` file and pipes outputs safely into `output.txt`.
