/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.data;

import java.util.LinkedList;

/**
 *
 * @author Mega Store
 */
class HashTable {
    Double[] table;
    int size;
    private final LinkedList[] chainTable;

    public HashTable(int size) {
        this.size = size;
        this.table = new Double[size];
        
        this.chainTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
        chainTable[i] = new LinkedList<>();
    }
    }

    private int hash1(double key) {
        return (int) (Math.abs(key) % size) ;
    }

    private int hash2(double key) {
        return 7 - (int) (Math.abs(key) % size);
    }

    public void insertDoubleHashing(double key) {
        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;

        while (table[(index + i * stepSize) % size] != null) {
            i++;
            if (i == size) {
                System.out.println("Hash Table is full!");
                return;
            }
        }
        table[(index + i * stepSize) % size] = key;
    }
    public void insertLinear(double key) {
        int index = hash1(key);
        int i = 0;
        while (i < size) {
            int newIndex = (index + i) % size;
            if (table[newIndex] == null) {
                table[newIndex] = key;
                return;
            }
            i++;
        }
        System.out.println("Linear Table is full!");
    }
    public void insertQuadratic(double key) {
        int index = hash1(key);
        int i = 0;
        while (i < size) {
            int newIndex = (index + (i * i)) % size;
            if (table[newIndex] == null) {
                table[newIndex] = key;
                return;
            }
            i++;
        }
        System.out.println("Quadratic Table is full!");
    }
    public void insertChaining(double key) {
        int index = hash1(key);
        chainTable[index].add(key);
    }
    public void printChainingTable() {
    System.out.println("Separate Chaining Table");
        for (int i = 0; i < size; i++) {
          System.out.print("Index " + i + ": ");
          java.util.List<Double> list = chainTable[i]; 
          if (list != null) {
              for (Object val : list) {
                  System.out.print(val + " -> ");
              }
           }
           System.out.println("null");
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + (table[i] == null ? "Empty" : table[i]));
        }
    }
}