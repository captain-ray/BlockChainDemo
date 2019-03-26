### Just get started to know how blockchain works



**A block consists of 3 main components:**

1. previous hash
2. current block transactions
3. current block hash



So, the current hash depends on the previous block, and the previous hash depends on the block before it. Once the block is tampered, its own hash would change. As a result, the hash of the following blocks will be changed either. So, once someone tries to tamper some info in one of the block, other people would easily find it because the hash will be found differently.



So, let's implement a simple demo to see how blockchain works.

FYI: hashcode function will give a unique code, like a  digital signiture.For example, the hashcode for "Hello" is something like -1823891, and for "Hello2" will be something like 823771.

```java
public class Block {
    private int previousHash;
    private String[] transactions;
    private int currentBlockHash;
  
   public Block(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        Object[] combine={previousHash,Arrays.hashCode(transactions)}; 
        this.currentBlockHash= Arrays.hashCode(combine);
    }

```

We can see that currentBlockHash is calculated depends on the previous hash and the current transactions.



All right, once the basic block is constructed, let's move to the next. 

```java

String[] genesisTransactions={"Satoshi sent me 10000000 bitcoins","I sent back Satoshi 1 bitcoin,hhhhhh"};
Block genesisBlock=new Block(0,genesisTransactions);
System.out.println(genesisBlock.getCurrentBlockHash());

```

In the main function, I manually define the very first block called genesis block, containing its own hash and transactions.(Satoshi is the one developed bitcoin:) )

> -1971114405  //  hashcode of the genesis block



Then, I will define two following blocks(block1,block2)

```java

String[] transactions1={"Satoshi sent Obama 10 bitcoins","Obama sent Ray 1 bitcoin"};
Block block1=new Block(genesisBlock.getCurrentBlockHash(),transactions1);
System.out.println(block1.getCurrentBlockHash());

String[] transactions2={"Satoshi sent James 999 bitcoins","James sent Satoshi 900 bitcoins"};
Block block2=new Block(block1.getCurrentBlockHash(),transactions2);
System.out.println(block2.getCurrentBlockHash());
```

> -1971114405 // hashcode of genesis block
>
> -855672335 // hashcode of block1
>
> -478407549 // hashcode of block2



In order to see how tampering the previous block will affect the following blocks, I will change the transactions in the genesis block to  *"Ray sent Satoshi 10000000 bitcoins"," Satoshi sent back 1 bitcoin,hhhhhh"*



The result will be different:

> 1113972026 //hashcode of genesis block
>
> 292726514 //hashcode of block1
>
> 762218402 //hashcode of block2



What I've learned is from [here](https://www.youtube.com/watch?v=baJYhYsHkLM). Thanks, Ivan.