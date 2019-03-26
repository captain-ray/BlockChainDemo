import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] genesisTransactions={"Ray sent Satoshi 10000000 bitcoins\",\" Satoshi sent back 1 bitcoin,hhhhhh"};
        Block genesisBlock=new Block(0,genesisTransactions);
        System.out.println(genesisBlock.getCurrentBlockHash());


        String[] transactions1={"Satoshi sent Obama 10 bitcoins","Obama sent Ray 1 bitcoin"};
        Block block1=new Block(genesisBlock.getCurrentBlockHash(),transactions1);
        System.out.println(block1.getCurrentBlockHash());


        String[] transactions2={"Satoshi sent James 999 bitcoins","James sent Satoshi 900 bitcoins"};
        Block block2=new Block(block1.getCurrentBlockHash(),transactions2);
        System.out.println(block2.getCurrentBlockHash());

    }
}
