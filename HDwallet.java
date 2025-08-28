package com.charles.example;

import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicHierarchy;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.web3j.crypto.MnemonicUtils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

public class HDwallet {
    public static void getHDWallet(String input){
        Security.addProvider(new BouncyCastleProvider());

        SecureRandom randent = new SecureRandom();
        byte[] entropy = new byte[16];
        randent.nextBytes(entropy);

        String mnemonic = MnemonicUtils.generateMnemonic(entropy);
        System.out.println("Mnemonic Phrase: " + mnemonic);
        byte[] seed = MnemonicUtils.generateSeed(mnemonic, " ");
        
        // BIP39
        DeterministicKey masterkey = HDKeyDerivation.createMasterPrivateKey(seed);
        
        // BIP33/44, First Set a Path for the ChildKey (HD)
        List<ChildNumber> path = Arrays.asList(
                new ChildNumber(44, true),
                new ChildNumber(60, true), // Eth Coin Number
                new ChildNumber(0, true),
                new ChildNumber(0, false),
                new ChildNumber(0, false)
        );
        DeterministicHierarchy dh = new DeterministicHierarchy(masterkey);
        DeterministicKey ChildKey = dh.get(path, true, true);

        BigInteger childpriv = ChildKey.getPrivKey();
        // Optional Printout
        
        // Now Get Pub key and derive ETH Wallet Address from it
        byte[] childpub = ChildKey.getPubKey();
        Keccak.Digest256 keccak = new Keccak.Digest256();
        keccak.update(childpub, 0, childpub.length);
        byte[] hash = keccak.digest();
        byte[] EthAddress = Arrays.copyOfRange(hash, 12, 32); // Slice out the last 20
        System.out.println("ETHEREUM WALLET ADDRESS: " + "0x" + Hexing.GetHex(EthAddress));
    }
}
