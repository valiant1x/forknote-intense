include ../make_config.mk

<<<<<<< HEAD
=======
ifndef DISABLE_JEMALLOC
	ifdef JEMALLOC
		PLATFORM_CXXFLAGS += "-DROCKSDB_JEMALLOC"
	endif
	EXEC_LDFLAGS := $(JEMALLOC_LIB) $(EXEC_LDFLAGS) -lpthread
	PLATFORM_CXXFLAGS += $(JEMALLOC_INCLUDE)
endif
	
>>>>>>> forknote/master
.PHONY: clean librocksdb

all: simple_example column_families_example compact_files_example c_simple_example optimistic_transaction_example transaction_example

simple_example: librocksdb simple_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

column_families_example: librocksdb column_families_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

compaction_filter_example: librocksdb compaction_filter_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

compact_files_example: librocksdb compact_files_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

.c.o:
	$(CC) $(CFLAGS) -c $< -o $@ -I../include

c_simple_example: librocksdb c_simple_example.o
	$(CXX) $@.o -o$@ ../librocksdb.a $(PLATFORM_LDFLAGS) $(EXEC_LDFLAGS)

optimistic_transaction_example: librocksdb optimistic_transaction_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

transaction_example: librocksdb transaction_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

<<<<<<< HEAD
=======
options_file_example: librocksdb options_file_example.cc
	$(CXX) $(CXXFLAGS) $@.cc -o$@ ../librocksdb.a -I../include -O2 -std=c++11 $(PLATFORM_LDFLAGS) $(PLATFORM_CXXFLAGS) $(EXEC_LDFLAGS)

>>>>>>> forknote/master
clean:
	rm -rf ./simple_example ./column_families_example ./compact_files_example ./compaction_filter_example ./c_simple_example c_simple_example.o ./optimistic_transaction_example ./transaction_example

librocksdb:
<<<<<<< HEAD
	cd .. && $(MAKE) librocksdb.a
=======
	cd .. && $(MAKE) static_lib
>>>>>>> forknote/master
