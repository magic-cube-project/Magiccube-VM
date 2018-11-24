## install cmake

apt-get install cmake

## install JDK 8

add-apt-repository ppa:webupd8team/java
apt-get update
apt-get install oracle-java8-installer -y
apt-get install oracle-java8-set-default -y


## libcurl install

wget https://curl.haxx.se/download/curl-7.61.1.tar.gz

tar -zxvf curl-*.tar.gz

./configure

make && make install

## libev install 

tar -zxvf libev-*.tar.gz

./configure

make && make install


## zookeeper install

wget https://archive.apache.org/dist/zookeeper/zookeeper-3.4.5/zookeeper-3.4.5.tar.gz
tar -zxvf zookeeper-*.tar.gz


## jansson install
wget http://www.digip.org/jansson/releases/jansson-2.11.tar.gz
tar -zxvf jansson-*.tar.bz
./configure
make && make install

## librdkafaka install

git clone https://github.com/edenhill/librdkafka
./configure
make && make install

## libmpdec install
wget http://www.bytereef.org/software/mpdecimal/releases/mpdecimal-2.4.2.tar.gz
tar -zxvf mpdecimal-*.tar.gz
./configure
make && make install


## openssl install

git clone https://github.com/openssl/openssl.git
./config
make && make install
