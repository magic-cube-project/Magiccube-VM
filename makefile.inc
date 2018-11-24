SOURCE  := $(wildcard *.c)
OBJS    := $(patsubst %.c, %.o, $(SOURCE))
CC      := gcc
CFLAGS  := -Wall -Wno-strict-aliasing -Wno-uninitialized -g -rdynamic -std=gnu99 -fPIC
LFLAGS  := -g -rdynamic 


.PHONY : all clean install 

all : $(TARGET) $(LIB)

clean :
	rm -rf *.d *.o $(TARGET) $($LIB)

$(TARGET) : $(OBJS)
	$(CC) $(LFLAGS) -o $@ $(OBJS) $(LIBS)
	rm -rf *.o
.c.o :
	$(CC) $(CFLAGS) -c -o $@ $< $(INCS)

install :

