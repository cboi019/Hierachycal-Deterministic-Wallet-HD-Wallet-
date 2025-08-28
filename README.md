HDWallet & Ethereum Address Generator

Description:
This Java project demonstrates how to generate an HD (Hierarchical Deterministic) wallet using BIP39 mnemonic phrases, derive a BIP44 Ethereum address, and integrate simple user data hashing with SHA-256 and Merkle root. Ideal for learning blockchain wallet mechanics and cryptographic key derivation.

Features:

Generates random entropy for BIP39 mnemonic phrases.

Derives master and child keys using BIP32/44 paths.

Extracts child private key (for learning purposes) and computes Ethereum address using Keccak-256.

Integrates user account information, computes Merkle root, and hashes it via SHA-256.

How to Run:

Clone the project and open it in your preferred Java IDE.

Run Main.java to generate a wallet and see account information, mnemonic, private key (hex), and Ethereum address.

For real-world applications, do not print or expose private keys.

Dependencies:

BitcoinJ (org.bitcoinj:bitcoinj-core)

BouncyCastle (org.bouncycastle:bcprov-jdk15on)

Web3j (org.web3j:core)

Security Note:

This project is for educational purposes only. Never expose private keys in production applications.
