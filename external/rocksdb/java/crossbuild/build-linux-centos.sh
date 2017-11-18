#!/usr/bin/env bash
# install all required packages for rocksdb that are available through yum
ARCH=$(uname -i)
<<<<<<< HEAD
sudo yum -y install openssl java-1.7.0-openjdk-devel.$ARCH zlib zlib-devel bzip2 bzip2-devel
=======
sudo yum -y install openssl java-1.7.0-openjdk-devel.$ARCH 
>>>>>>> forknote/master

# install gcc/g++ 4.8.2 via CERN (http://linux.web.cern.ch/linux/devtoolset/)
sudo wget -O /etc/yum.repos.d/slc5-devtoolset.repo http://linuxsoft.cern.ch/cern/devtoolset/slc5-devtoolset.repo
sudo wget -O /etc/pki/rpm-gpg/RPM-GPG-KEY-cern http://ftp.mirrorservice.org/sites/ftp.scientificlinux.org/linux/scientific/51/i386/RPM-GPG-KEYs/RPM-GPG-KEY-cern
sudo yum -y install devtoolset-2

<<<<<<< HEAD
wget http://gflags.googlecode.com/files/gflags-1.6.tar.gz
tar xvfz gflags-1.6.tar.gz; cd gflags-1.6; scl enable devtoolset-2 ./configure; scl enable devtoolset-2 make; sudo make install
=======
wget http://gflags.googlecode.com/files/gflags-2.0-no-svn-files.tar.gz
tar xvfz gflags-2.0-no-svn-files.tar.gz; cd gflags-2.0; scl enable devtoolset-2 ./configure; scl enable devtoolset-2 make; sudo make install
>>>>>>> forknote/master
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/lib

# set java home so we can build rocksdb jars
export JAVA_HOME=/usr/lib/jvm/java-1.7.0

# build rocksdb
cd /rocksdb
scl enable devtoolset-2 'make jclean clean'
<<<<<<< HEAD
scl enable devtoolset-2 'make rocksdbjavastatic'
=======
scl enable devtoolset-2 'PORTABLE=1 make rocksdbjavastatic'
>>>>>>> forknote/master
cp /rocksdb/java/target/librocksdbjni-* /rocksdb-build
cp /rocksdb/java/target/rocksdbjni-* /rocksdb-build

