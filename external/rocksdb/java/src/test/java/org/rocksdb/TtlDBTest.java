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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> forknote/master
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TtlDBTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public TemporaryFolder dbFolder = new TemporaryFolder();

  @Test
<<<<<<< HEAD
  public void ttlDBOpen() throws RocksDBException,
      InterruptedException {
    Options options = null;
    TtlDB ttlDB = null;
    try {
      options = new Options().
          setCreateIfMissing(true).
          setMaxGrandparentOverlapFactor(0);
      ttlDB = TtlDB.open(options,
          dbFolder.getRoot().getAbsolutePath());
=======
  public void ttlDBOpen() throws RocksDBException, InterruptedException {
    try (final Options options = new Options()
        .setCreateIfMissing(true)
        .setMaxGrandparentOverlapFactor(0);
         final TtlDB ttlDB = TtlDB.open(options,
             dbFolder.getRoot().getAbsolutePath())
    ) {
>>>>>>> forknote/master
      ttlDB.put("key".getBytes(), "value".getBytes());
      assertThat(ttlDB.get("key".getBytes())).
          isEqualTo("value".getBytes());
      assertThat(ttlDB.get("key".getBytes())).isNotNull();
<<<<<<< HEAD
    } finally {
      if (ttlDB != null) {
        ttlDB.close();
      }
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void ttlDBOpenWithTtl() throws RocksDBException,
      InterruptedException {
    Options options = null;
    TtlDB ttlDB = null;
    try {
      options = new Options().
          setCreateIfMissing(true).
          setMaxGrandparentOverlapFactor(0);
      ttlDB = TtlDB.open(options, dbFolder.getRoot().getAbsolutePath(),
          1, false);
=======
  public void ttlDBOpenWithTtl() throws RocksDBException, InterruptedException {
    try (final Options options = new Options()
        .setCreateIfMissing(true)
        .setMaxGrandparentOverlapFactor(0);
         final TtlDB ttlDB = TtlDB.open(options,
             dbFolder.getRoot().getAbsolutePath(), 1, false);
    ) {
>>>>>>> forknote/master
      ttlDB.put("key".getBytes(), "value".getBytes());
      assertThat(ttlDB.get("key".getBytes())).
          isEqualTo("value".getBytes());
      TimeUnit.SECONDS.sleep(2);
<<<<<<< HEAD

      ttlDB.compactRange();
      assertThat(ttlDB.get("key".getBytes())).isNull();
    } finally {
      if (ttlDB != null) {
        ttlDB.close();
      }
      if (options != null) {
        options.dispose();
      }
=======
      ttlDB.compactRange();
      assertThat(ttlDB.get("key".getBytes())).isNull();
>>>>>>> forknote/master
    }
  }

  @Test
<<<<<<< HEAD
  public void ttlDbOpenWithColumnFamilies() throws RocksDBException, InterruptedException {
    DBOptions dbOptions = null;
    TtlDB ttlDB = null;
    List<ColumnFamilyDescriptor> cfNames =
        new ArrayList<>();
    List<ColumnFamilyHandle> columnFamilyHandleList =
        new ArrayList<>();
    cfNames.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY));
    cfNames.add(new ColumnFamilyDescriptor("new_cf".getBytes()));
    List<Integer> ttlValues = new ArrayList<>();
    // Default column family with infinite lifetime
    ttlValues.add(0);
    // new column family with 1 second ttl
    ttlValues.add(1);

    try {
      dbOptions = new DBOptions().
          setCreateMissingColumnFamilies(true).
          setCreateIfMissing(true);
      ttlDB = TtlDB.open(dbOptions, dbFolder.getRoot().getAbsolutePath(),
          cfNames, columnFamilyHandleList, ttlValues, false);

      ttlDB.put("key".getBytes(), "value".getBytes());
      assertThat(ttlDB.get("key".getBytes())).
          isEqualTo("value".getBytes());
      ttlDB.put(columnFamilyHandleList.get(1), "key".getBytes(),
          "value".getBytes());
      assertThat(ttlDB.get(columnFamilyHandleList.get(1),
          "key".getBytes())).isEqualTo("value".getBytes());
      TimeUnit.SECONDS.sleep(2);

      ttlDB.compactRange();
      ttlDB.compactRange(columnFamilyHandleList.get(1));

      assertThat(ttlDB.get("key".getBytes())).isNotNull();
      assertThat(ttlDB.get(columnFamilyHandleList.get(1),
          "key".getBytes())).isNull();


    } finally {
      for (ColumnFamilyHandle columnFamilyHandle :
          columnFamilyHandleList) {
        columnFamilyHandle.dispose();
      }
      if (ttlDB != null) {
        ttlDB.close();
      }
      if (dbOptions != null) {
        dbOptions.dispose();
=======
  public void ttlDbOpenWithColumnFamilies() throws RocksDBException,
      InterruptedException {
    final List<ColumnFamilyDescriptor> cfNames = Arrays.asList(
        new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY),
        new ColumnFamilyDescriptor("new_cf".getBytes())
    );
    final List<Integer> ttlValues = Arrays.asList(0, 1);

    final List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<>();
    try (final DBOptions dbOptions = new DBOptions()
        .setCreateMissingColumnFamilies(true)
        .setCreateIfMissing(true);
         final TtlDB ttlDB = TtlDB.open(dbOptions,
             dbFolder.getRoot().getAbsolutePath(), cfNames,
             columnFamilyHandleList, ttlValues, false)) {
      try {
        ttlDB.put("key".getBytes(), "value".getBytes());
        assertThat(ttlDB.get("key".getBytes())).
            isEqualTo("value".getBytes());
        ttlDB.put(columnFamilyHandleList.get(1), "key".getBytes(),
            "value".getBytes());
        assertThat(ttlDB.get(columnFamilyHandleList.get(1),
            "key".getBytes())).isEqualTo("value".getBytes());
        TimeUnit.SECONDS.sleep(2);

        ttlDB.compactRange();
        ttlDB.compactRange(columnFamilyHandleList.get(1));

        assertThat(ttlDB.get("key".getBytes())).isNotNull();
        assertThat(ttlDB.get(columnFamilyHandleList.get(1),
            "key".getBytes())).isNull();
      } finally {
        for (final ColumnFamilyHandle columnFamilyHandle :
            columnFamilyHandleList) {
          columnFamilyHandle.close();
        }
>>>>>>> forknote/master
      }
    }
  }

  @Test
  public void createTtlColumnFamily() throws RocksDBException,
      InterruptedException {
<<<<<<< HEAD
    Options options = null;
    TtlDB ttlDB = null;
    ColumnFamilyHandle columnFamilyHandle = null;
    try {
      options = new Options().setCreateIfMissing(true);
      ttlDB = TtlDB.open(options,
          dbFolder.getRoot().getAbsolutePath());
      columnFamilyHandle = ttlDB.createColumnFamilyWithTtl(
          new ColumnFamilyDescriptor("new_cf".getBytes()), 1);
=======
    try (final Options options = new Options().setCreateIfMissing(true);
         final TtlDB ttlDB = TtlDB.open(options,
             dbFolder.getRoot().getAbsolutePath());
         final ColumnFamilyHandle columnFamilyHandle =
             ttlDB.createColumnFamilyWithTtl(
                 new ColumnFamilyDescriptor("new_cf".getBytes()), 1)) {
>>>>>>> forknote/master
      ttlDB.put(columnFamilyHandle, "key".getBytes(),
          "value".getBytes());
      assertThat(ttlDB.get(columnFamilyHandle, "key".getBytes())).
          isEqualTo("value".getBytes());
      TimeUnit.SECONDS.sleep(2);
      ttlDB.compactRange(columnFamilyHandle);
      assertThat(ttlDB.get(columnFamilyHandle, "key".getBytes())).isNull();
<<<<<<< HEAD
    } finally {
      if (columnFamilyHandle != null) {
        columnFamilyHandle.dispose();
      }
      if (ttlDB != null) {
        ttlDB.close();
      }
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }
}
