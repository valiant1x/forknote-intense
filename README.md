## NOTE
This repo is defunct and does not currently support the block 76500 difficulty algorithm change for Intensecoin!

### About
Forknote is innovative way to create Cryptonote (https://cryptonote.org) based cryptotokens. It gives the users the ability to create cryptotokens just by creating a simple configuration file.

### Dependencies
* GCC 4.7.3 or later     (http://gcc.gnu.org/)
* CMake 2.8.6 or later   (http://www.cmake.org/)
* Boost 1.55 or later    (http://www.boost.org/)
* MSVC 2013 (Windows only)

Step by step Windows instructions:
https://github.com/forknote/cryptonote-generator/blob/master/docs/windows-requirements-install.md

Ubuntu (tested on Ubuntu 14.04) / Mac dependencies install script:
https://github.com/forknote/cryptonote-generator/blob/master/configure.sh


### Usage
1. Download or compile the binaries
2. Create configuration file. The easiest way is to use the form on http://forknote.net
3. Start the daemon:
```
./forknoted --config-file PATH_TO_YOUR_CONFIG
```

### Configuration parameters
Use the following configuration for Intense Coin:

```
GENESIS_COINBASE_TX_HEX=013c01ff0001af9ea896c605029b2e4c0281c0b02e7c53291a94d1d0cbff8883f8024f5142ee494ffbbd0880712101e444827ebec7bfe1938c8505128cbcf59343e9651afb0893d3d664f560fd216f
CRYPTONOTE_NAME=intensecoin
p2p-bind-port=48772
rpc-bind-port=48782
seed-node=45.32.171.89:48772
seed-node=104.200.65.202:48772
seed-node=192.124.18.154:48772    
UPGRADE_HEIGHT_V2=50000
UPGRADE_HEIGHT_V3=999999
MONEY_SUPPLY=99948151623421337
EMISSION_SPEED_FACTOR=19
GENESIS_BLOCK_REWARD=190635970351
DIFFICULTY_TARGET=120
CRYPTONOTE_DISPLAY_DECIMAL_POINT=8
DEFAULT_DUST_THRESHOLD=100000
MINIMUM_FEE=100000
DIFFICULTY_WINDOW=720
KEY_IMAGE_CHECKING_BLOCK_INDEX=5500
EXPECTED_NUMBER_OF_BLOCKS_PER_DAY=720
TAIL_EMISSION_REWARD=5800000000
CRYPTONOTE_MINED_MONEY_UNLOCK_WINDOW=60
CRYPTONOTE_BLOCK_GRANTED_FULL_REWARD_ZONE_V1=20000
CRYPTONOTE_BLOCK_GRANTED_FULL_REWARD_ZONE_V2=1000000
CRYPTONOTE_BLOCK_GRANTED_FULL_REWARD_ZONE=100000
CRYPTONOTE_PUBLIC_ADDRESS_BASE58_PREFIX=-11
BYTECOIN_NETWORK=8c403d04-8f82-2c3d-825f-2c1a44327d82
P2P_STAT_TRUSTED_PUB_KEY=8f80f9a5a434a9f1510d13336228debfee9c918ce505efe225d8c94d045fa115
CHECKPOINT=1000:95e016693e0422dbfec51e74342bebcad7b7684f04040c559b9284f937ad1d32
rpc-bind-ip=0.0.0.0
enable-blockchain-indexes=1
enable-cors=*

wallet-rpc-bind-ip=127.0.0.1        // instead rpc-bind-ip
wallet-rpc-bind-port=48782          // instead rpc-bind-port
SYNC_FROM_ZERO=1                    // to sync the wallet from block 0. Used for premine coins or brain wallets
```

---
Seed source - https://github.com/amjuarez/bytecoin
