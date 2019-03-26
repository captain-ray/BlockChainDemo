import java.util.Arrays;

/**
 * Created by ray on 26/3/19.
 */
public class Block {
    /*
    * A block consists of 3 main components
    * 1.previous hash
    * 2.current transactions
    * 3.current block hash
    * */
    private int previousHash;
    private String[] transactions;

    private int currentBlockHash;

    public Block(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;

//        Object[] combine={previousHash,transactions}; //it won't work, transactions have to be hashed first
        Object[] combine={previousHash,Arrays.hashCode(transactions)};
        this.currentBlockHash= Arrays.hashCode(combine);
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public int getCurrentBlockHash() {
        return currentBlockHash;
    }
}
