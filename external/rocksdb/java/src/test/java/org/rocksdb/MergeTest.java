<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> forknote/master
import java.util.List;
import java.util.ArrayList;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public TemporaryFolder dbFolder = new TemporaryFolder();

  @Test
  public void stringOption()
      throws InterruptedException, RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Options opt = null;
    try {
      String db_path_string =
          dbFolder.getRoot().getAbsolutePath();
      opt = new Options();
      opt.setCreateIfMissing(true);
      opt.setMergeOperatorName("stringappend");

      db = RocksDB.open(opt, db_path_string);
=======
    try (final Options opt = new Options()
        .setCreateIfMissing(true)
        .setMergeOperatorName("stringappend");
         final RocksDB db = RocksDB.open(opt,
             dbFolder.getRoot().getAbsolutePath())) {
>>>>>>> forknote/master
      // writing aa under key
      db.put("key".getBytes(), "aa".getBytes());
      // merge bb under key
      db.merge("key".getBytes(), "bb".getBytes());

<<<<<<< HEAD
      byte[] value = db.get("key".getBytes());
      String strValue = new String(value);
      assertThat(strValue).isEqualTo("aa,bb");
    } finally {
      if (db != null) {
        db.close();
      }
      if (opt != null) {
        opt.dispose();
      }
=======
      final byte[] value = db.get("key".getBytes());
      final String strValue = new String(value);
      assertThat(strValue).isEqualTo("aa,bb");
>>>>>>> forknote/master
    }
  }

  @Test
  public void cFStringOption()
      throws InterruptedException, RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    DBOptions opt = null;
    List<ColumnFamilyHandle> columnFamilyHandleList =
        new ArrayList<>();
    try {
      String db_path_string =
          dbFolder.getRoot().getAbsolutePath();
      opt = new DBOptions();
      opt.setCreateIfMissing(true);
      opt.setCreateMissingColumnFamilies(true);

      List<ColumnFamilyDescriptor> cfDescriptors =
          new ArrayList<>();
      cfDescriptors.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY,
          new ColumnFamilyOptions().setMergeOperatorName(
              "stringappend")));
      cfDescriptors.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY,
          new ColumnFamilyOptions().setMergeOperatorName(
              "stringappend")));
      db = RocksDB.open(opt, db_path_string,
          cfDescriptors, columnFamilyHandleList);

      // writing aa under key
      db.put(columnFamilyHandleList.get(1),
          "cfkey".getBytes(), "aa".getBytes());
      // merge bb under key
      db.merge(columnFamilyHandleList.get(1),
          "cfkey".getBytes(), "bb".getBytes());

      byte[] value = db.get(columnFamilyHandleList.get(1), "cfkey".getBytes());
      String strValue = new String(value);
      assertThat(strValue).isEqualTo("aa,bb");
    } finally {
      for (ColumnFamilyHandle handle : columnFamilyHandleList) {
        handle.dispose();
      }
      if (db != null) {
        db.close();
      }
      if (opt != null) {
        opt.dispose();
=======

    try (final ColumnFamilyOptions cfOpt1 = new ColumnFamilyOptions()
        .setMergeOperatorName("stringappend");
         final ColumnFamilyOptions cfOpt2 = new ColumnFamilyOptions()
             .setMergeOperatorName("stringappend")
    ) {
      final List<ColumnFamilyDescriptor> cfDescriptors = Arrays.asList(
          new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpt1),
          new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpt2)
      );

      final List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<>();
      try (final DBOptions opt = new DBOptions()
          .setCreateIfMissing(true)
          .setCreateMissingColumnFamilies(true);
           final RocksDB db = RocksDB.open(opt,
               dbFolder.getRoot().getAbsolutePath(), cfDescriptors,
               columnFamilyHandleList)) {
        try {
          // writing aa under key
          db.put(columnFamilyHandleList.get(1),
              "cfkey".getBytes(), "aa".getBytes());
          // merge bb under key
          db.merge(columnFamilyHandleList.get(1),
              "cfkey".getBytes(), "bb".getBytes());

          byte[] value = db.get(columnFamilyHandleList.get(1),
              "cfkey".getBytes());
          String strValue = new String(value);
          assertThat(strValue).isEqualTo("aa,bb");
        } finally {
          for (final ColumnFamilyHandle handle : columnFamilyHandleList) {
            handle.close();
          }
        }
>>>>>>> forknote/master
      }
    }
  }

  @Test
  public void operatorOption()
      throws InterruptedException, RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Options opt = null;
    try {
      String db_path_string =
          dbFolder.getRoot().getAbsolutePath();
      opt = new Options();
      opt.setCreateIfMissing(true);

      StringAppendOperator stringAppendOperator = new StringAppendOperator();
      opt.setMergeOperator(stringAppendOperator);

      db = RocksDB.open(opt, db_path_string);
=======
    final StringAppendOperator stringAppendOperator =
        new StringAppendOperator();
    try (final Options opt = new Options()
        .setCreateIfMissing(true)
        .setMergeOperator(stringAppendOperator);
         final RocksDB db = RocksDB.open(opt,
             dbFolder.getRoot().getAbsolutePath())) {
>>>>>>> forknote/master
      // Writing aa under key
      db.put("key".getBytes(), "aa".getBytes());

      // Writing bb under key
      db.merge("key".getBytes(), "bb".getBytes());

<<<<<<< HEAD
      byte[] value = db.get("key".getBytes());
      String strValue = new String(value);

      assertThat(strValue).isEqualTo("aa,bb");
    } finally {
      if (db != null) {
        db.close();
      }
      if (opt != null) {
        opt.dispose();
      }
=======
      final byte[] value = db.get("key".getBytes());
      final String strValue = new String(value);

      assertThat(strValue).isEqualTo("aa,bb");
>>>>>>> forknote/master
    }
  }

  @Test
  public void cFOperatorOption()
      throws InterruptedException, RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    DBOptions opt = null;
    ColumnFamilyHandle cfHandle = null;
    List<ColumnFamilyDescriptor> cfDescriptors =
        new ArrayList<>();
    List<ColumnFamilyHandle> columnFamilyHandleList =
        new ArrayList<>();
    try {
      String db_path_string =
          dbFolder.getRoot().getAbsolutePath();
      opt = new DBOptions();
      opt.setCreateIfMissing(true);
      opt.setCreateMissingColumnFamilies(true);
      StringAppendOperator stringAppendOperator = new StringAppendOperator();

      cfDescriptors.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY,
          new ColumnFamilyOptions().setMergeOperator(
              stringAppendOperator)));
      cfDescriptors.add(new ColumnFamilyDescriptor("new_cf".getBytes(),
          new ColumnFamilyOptions().setMergeOperator(
              stringAppendOperator)));
      db = RocksDB.open(opt, db_path_string,
          cfDescriptors, columnFamilyHandleList);

      // writing aa under key
      db.put(columnFamilyHandleList.get(1),
          "cfkey".getBytes(), "aa".getBytes());
      // merge bb under key
      db.merge(columnFamilyHandleList.get(1),
          "cfkey".getBytes(), "bb".getBytes());
      byte[] value = db.get(columnFamilyHandleList.get(1), "cfkey".getBytes());
      String strValue = new String(value);

      // Test also with createColumnFamily
      cfHandle = db.createColumnFamily(
          new ColumnFamilyDescriptor("new_cf2".getBytes(),
              new ColumnFamilyOptions().setMergeOperator(stringAppendOperator)));
      // writing xx under cfkey2
      db.put(cfHandle, "cfkey2".getBytes(), "xx".getBytes());
      // merge yy under cfkey2
      db.merge(cfHandle, new WriteOptions(), "cfkey2".getBytes(), "yy".getBytes());
      value = db.get(cfHandle, "cfkey2".getBytes());
      String strValueTmpCf = new String(value);

      assertThat(strValue).isEqualTo("aa,bb");
      assertThat(strValueTmpCf).isEqualTo("xx,yy");
    } finally {
      for (ColumnFamilyHandle columnFamilyHandle : columnFamilyHandleList) {
        columnFamilyHandle.dispose();
      }
      if (cfHandle != null) {
        cfHandle.dispose();
      }
      if (db != null) {
        db.close();
      }
      if (opt != null) {
        opt.dispose();
=======
    final StringAppendOperator stringAppendOperator =
        new StringAppendOperator();
    try (final ColumnFamilyOptions cfOpt1 = new ColumnFamilyOptions()
        .setMergeOperator(stringAppendOperator);
         final ColumnFamilyOptions cfOpt2 = new ColumnFamilyOptions()
             .setMergeOperator(stringAppendOperator)
    ) {
      final List<ColumnFamilyDescriptor> cfDescriptors = Arrays.asList(
          new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpt1),
          new ColumnFamilyDescriptor("new_cf".getBytes(), cfOpt2)
      );
      final List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<>();
      try (final DBOptions opt = new DBOptions()
          .setCreateIfMissing(true)
          .setCreateMissingColumnFamilies(true);
           final RocksDB db = RocksDB.open(opt,
               dbFolder.getRoot().getAbsolutePath(), cfDescriptors,
               columnFamilyHandleList)
      ) {
        try {
          // writing aa under key
          db.put(columnFamilyHandleList.get(1),
              "cfkey".getBytes(), "aa".getBytes());
          // merge bb under key
          db.merge(columnFamilyHandleList.get(1),
              "cfkey".getBytes(), "bb".getBytes());
          byte[] value = db.get(columnFamilyHandleList.get(1),
              "cfkey".getBytes());
          String strValue = new String(value);

          // Test also with createColumnFamily
          try (final ColumnFamilyOptions cfHandleOpts =
                   new ColumnFamilyOptions()
                       .setMergeOperator(stringAppendOperator);
               final ColumnFamilyHandle cfHandle =
                   db.createColumnFamily(
                       new ColumnFamilyDescriptor("new_cf2".getBytes(),
                           cfHandleOpts))
          ) {
            // writing xx under cfkey2
            db.put(cfHandle, "cfkey2".getBytes(), "xx".getBytes());
            // merge yy under cfkey2
            db.merge(cfHandle, new WriteOptions(), "cfkey2".getBytes(),
                "yy".getBytes());
            value = db.get(cfHandle, "cfkey2".getBytes());
            String strValueTmpCf = new String(value);

            assertThat(strValue).isEqualTo("aa,bb");
            assertThat(strValueTmpCf).isEqualTo("xx,yy");
          }
        } finally {
          for (final ColumnFamilyHandle columnFamilyHandle :
              columnFamilyHandleList) {
            columnFamilyHandle.close();
          }
        }
>>>>>>> forknote/master
      }
    }
  }

  @Test
  public void operatorGcBehaviour()
      throws RocksDBException {
<<<<<<< HEAD
    Options opt = null;
    RocksDB db = null;
    try {
      String db_path_string =
          dbFolder.getRoot().getAbsolutePath();
      opt = new Options();
      opt.setCreateIfMissing(true);
      StringAppendOperator stringAppendOperator = new StringAppendOperator();
      opt.setMergeOperator(stringAppendOperator);
      db = RocksDB.open(opt, db_path_string);
      db.close();
      opt.dispose();
      System.gc();
      System.runFinalization();
      // test reuse
      opt = new Options();
      opt.setMergeOperator(stringAppendOperator);
      db = RocksDB.open(opt, db_path_string);
      db.close();
      opt.dispose();
      System.gc();
      System.runFinalization();
      // test param init
      opt = new Options();
      opt.setMergeOperator(new StringAppendOperator());
      db = RocksDB.open(opt, db_path_string);
      db.close();
      opt.dispose();
      System.gc();
      System.runFinalization();
      // test replace one with another merge operator instance
      opt = new Options();
      opt.setMergeOperator(stringAppendOperator);
      StringAppendOperator newStringAppendOperator = new StringAppendOperator();
      opt.setMergeOperator(newStringAppendOperator);
      db = RocksDB.open(opt, db_path_string);
      db.close();
      opt.dispose();
    } finally {
      if (db != null) {
        db.close();
      }
      if (opt != null) {
        opt.dispose();
=======
    final StringAppendOperator stringAppendOperator
        = new StringAppendOperator();
    try (final Options opt = new Options()
        .setCreateIfMissing(true)
        .setMergeOperator(stringAppendOperator);
         final RocksDB db = RocksDB.open(opt,
             dbFolder.getRoot().getAbsolutePath())) {
      //no-op
    }

    // test reuse
    try (final Options opt = new Options()
        .setMergeOperator(stringAppendOperator);
         final RocksDB db = RocksDB.open(opt,
             dbFolder.getRoot().getAbsolutePath())) {
      //no-op
    }

    // test param init
    try (final Options opt = new Options()
        .setMergeOperator(new StringAppendOperator());
         final RocksDB db = RocksDB.open(opt,
             dbFolder.getRoot().getAbsolutePath())) {
      //no-op
    }

    // test replace one with another merge operator instance
    try (final Options opt = new Options()
        .setMergeOperator(stringAppendOperator)) {
      final StringAppendOperator newStringAppendOperator
          = new StringAppendOperator();
      opt.setMergeOperator(newStringAppendOperator);
      try (final RocksDB db = RocksDB.open(opt,
          dbFolder.getRoot().getAbsolutePath())) {
        //no-op
>>>>>>> forknote/master
      }
    }
  }

  @Test
  public void emptyStringInSetMergeOperatorByName() {
<<<<<<< HEAD
    Options opt = null;
    ColumnFamilyOptions cOpt = null;
    try {
      opt = new Options();
      cOpt = new ColumnFamilyOptions();
      opt.setMergeOperatorName("");
      cOpt.setMergeOperatorName("");
    } finally {
      if (opt != null) {
        opt.dispose();
      }
      if (cOpt != null) {
        cOpt.dispose();
      }
=======
    try (final Options opt = new Options()
        .setMergeOperatorName("");
         final ColumnFamilyOptions cOpt = new ColumnFamilyOptions()
             .setMergeOperatorName("")) {
      //no-op
>>>>>>> forknote/master
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullStringInSetMergeOperatorByNameOptions() {
<<<<<<< HEAD
    Options opt = null;
    try {
      opt = new Options();
      opt.setMergeOperatorName(null);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
    try (final Options opt = new Options()) {
      opt.setMergeOperatorName(null);
>>>>>>> forknote/master
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void
<<<<<<< HEAD
      nullStringInSetMergeOperatorByNameColumnFamilyOptions() {
    ColumnFamilyOptions opt = null;
    try {
      opt = new ColumnFamilyOptions();
      opt.setMergeOperatorName(null);
    } finally {
      if (opt != null) {
        opt.dispose();
      }
=======
  nullStringInSetMergeOperatorByNameColumnFamilyOptions() {
    try (final ColumnFamilyOptions opt = new ColumnFamilyOptions()) {
      opt.setMergeOperatorName(null);
>>>>>>> forknote/master
    }
  }
}
