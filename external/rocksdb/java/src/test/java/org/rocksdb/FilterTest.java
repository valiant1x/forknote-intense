<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

import org.junit.ClassRule;
import org.junit.Test;

public class FilterTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Test
  public void filter() {
<<<<<<< HEAD
    Options options = null;
    try {
      options = new Options();
      // test table config
      options.setTableFormatConfig(new BlockBasedTableConfig().
          setFilter(new BloomFilter()));
      options.dispose();
      System.gc();
      System.runFinalization();
      // new Bloom filter
      options = new Options();
      BlockBasedTableConfig blockConfig = new BlockBasedTableConfig();
      blockConfig.setFilter(new BloomFilter());
      options.setTableFormatConfig(blockConfig);
      BloomFilter bloomFilter = new BloomFilter(10);
      blockConfig.setFilter(bloomFilter);
      options.setTableFormatConfig(blockConfig);
      System.gc();
      System.runFinalization();
      blockConfig.setFilter(new BloomFilter(10, false));
      options.setTableFormatConfig(blockConfig);

    } finally {
      if (options != null) {
        options.dispose();
=======
    // new Bloom filter
    final BlockBasedTableConfig blockConfig = new BlockBasedTableConfig();
    try(final Options options = new Options()) {

      try(final Filter bloomFilter = new BloomFilter()) {
        blockConfig.setFilter(bloomFilter);
        options.setTableFormatConfig(blockConfig);
      }

      try(final Filter bloomFilter = new BloomFilter(10)) {
        blockConfig.setFilter(bloomFilter);
        options.setTableFormatConfig(blockConfig);
      }

      try(final Filter bloomFilter = new BloomFilter(10, false)) {
        blockConfig.setFilter(bloomFilter);
        options.setTableFormatConfig(blockConfig);
>>>>>>> forknote/master
      }
    }
  }
}
