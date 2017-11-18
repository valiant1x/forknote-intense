<<<<<<< HEAD
//  Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.
//
// Copyright (c) 2011 The LevelDB Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file. See the AUTHORS file for names of contributors.

package org.rocksdb;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

<<<<<<< HEAD
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
=======
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
>>>>>>> forknote/master

import static org.assertj.core.api.Assertions.assertThat;


public class WriteBatchWithIndexTest {

  @ClassRule
  public static final RocksMemoryResource rocksMemoryResource =
      new RocksMemoryResource();

  @Rule
  public TemporaryFolder dbFolder = new TemporaryFolder();

  @Test
  public void readYourOwnWrites() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Options options = null;
    try {
      options = new Options();
      // Setup options
      options.setCreateIfMissing(true);
      db = RocksDB.open(options, dbFolder.getRoot().getAbsolutePath());
=======
    try (final Options options = new Options().setCreateIfMissing(true);
         final RocksDB db = RocksDB.open(options,
             dbFolder.getRoot().getAbsolutePath())) {
>>>>>>> forknote/master

      final byte[] k1 = "key1".getBytes();
      final byte[] v1 = "value1".getBytes();
      final byte[] k2 = "key2".getBytes();
      final byte[] v2 = "value2".getBytes();

      db.put(k1, v1);
      db.put(k2, v2);

<<<<<<< HEAD
      final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true);

      RocksIterator base = null;
      RocksIterator it = null;
      try {
        base = db.newIterator();
        it = wbwi.newIteratorWithBase(base);
=======
      try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true);
           final RocksIterator base = db.newIterator();
           final RocksIterator it = wbwi.newIteratorWithBase(base)) {
>>>>>>> forknote/master

        it.seek(k1);
        assertThat(it.isValid()).isTrue();
        assertThat(it.key()).isEqualTo(k1);
        assertThat(it.value()).isEqualTo(v1);

        it.seek(k2);
        assertThat(it.isValid()).isTrue();
        assertThat(it.key()).isEqualTo(k2);
        assertThat(it.value()).isEqualTo(v2);

        //put data to the write batch and make sure we can read it.
        final byte[] k3 = "key3".getBytes();
        final byte[] v3 = "value3".getBytes();
        wbwi.put(k3, v3);
        it.seek(k3);
        assertThat(it.isValid()).isTrue();
        assertThat(it.key()).isEqualTo(k3);
        assertThat(it.value()).isEqualTo(v3);

        //update k2 in the write batch and check the value
        final byte[] v2Other = "otherValue2".getBytes();
        wbwi.put(k2, v2Other);
        it.seek(k2);
        assertThat(it.isValid()).isTrue();
        assertThat(it.key()).isEqualTo(k2);
        assertThat(it.value()).isEqualTo(v2Other);

        //remove k1 and make sure we can read back the write
        wbwi.remove(k1);
        it.seek(k1);
        assertThat(it.key()).isNotEqualTo(k1);

        //reinsert k1 and make sure we see the new value
        final byte[] v1Other = "otherValue1".getBytes();
        wbwi.put(k1, v1Other);
        it.seek(k1);
        assertThat(it.isValid()).isTrue();
        assertThat(it.key()).isEqualTo(k1);
        assertThat(it.value()).isEqualTo(v1Other);
<<<<<<< HEAD
      } finally {
        if (it != null) {
          it.dispose();
        }
        if (base != null) {
          base.dispose();
        }
      }

    } finally {
      if (db != null) {
        db.close();
      }
      if (options != null) {
        options.dispose();
=======
>>>>>>> forknote/master
      }
    }
  }

  @Test
  public void write_writeBatchWithIndex() throws RocksDBException {
<<<<<<< HEAD
    RocksDB db = null;
    Options options = null;
    try {
      options = new Options();
      // Setup options
      options.setCreateIfMissing(true);
      db = RocksDB.open(options, dbFolder.getRoot().getAbsolutePath());
=======
    try (final Options options = new Options().setCreateIfMissing(true);
         final RocksDB db = RocksDB.open(options,
             dbFolder.getRoot().getAbsolutePath())) {
>>>>>>> forknote/master

      final byte[] k1 = "key1".getBytes();
      final byte[] v1 = "value1".getBytes();
      final byte[] k2 = "key2".getBytes();
      final byte[] v2 = "value2".getBytes();

<<<<<<< HEAD
      WriteBatchWithIndex wbwi = null;

      try {
        wbwi = new WriteBatchWithIndex();


=======
      try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex()) {
>>>>>>> forknote/master
        wbwi.put(k1, v1);
        wbwi.put(k2, v2);

        db.write(new WriteOptions(), wbwi);
<<<<<<< HEAD
      } finally {
        if(wbwi != null) {
          wbwi.dispose();
        }
=======
>>>>>>> forknote/master
      }

      assertThat(db.get(k1)).isEqualTo(v1);
      assertThat(db.get(k2)).isEqualTo(v2);
<<<<<<< HEAD

    } finally {
      if (db != null) {
        db.close();
      }
      if (options != null) {
        options.dispose();
      }
=======
>>>>>>> forknote/master
    }
  }

  @Test
  public void iterator() throws RocksDBException {
<<<<<<< HEAD
    final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true);

    final String k1 = "key1";
    final String v1 = "value1";
    final String k2 = "key2";
    final String v2 = "value2";
    final String k3 = "key3";
    final String v3 = "value3";
    final byte[] k1b = k1.getBytes();
    final byte[] v1b = v1.getBytes();
    final byte[] k2b = k2.getBytes();
    final byte[] v2b = v2.getBytes();
    final byte[] k3b = k3.getBytes();
    final byte[] v3b = v3.getBytes();

    //add put records
    wbwi.put(k1b, v1b);
    wbwi.put(k2b, v2b);
    wbwi.put(k3b, v3b);

    //add a deletion record
    final String k4 = "key4";
    final byte[] k4b = k4.getBytes();
    wbwi.remove(k4b);

    WBWIRocksIterator.WriteEntry[] expected = {
        new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
            new DirectSlice(k1), new DirectSlice(v1)),
        new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
            new DirectSlice(k2), new DirectSlice(v2)),
        new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
            new DirectSlice(k3), new DirectSlice(v3)),
        new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.DELETE,
            new DirectSlice(k4), DirectSlice.NONE)
    };

    WBWIRocksIterator it = null;
    try {
      it = wbwi.newIterator();

      //direct access - seek to key offsets
      final int[] testOffsets = {2, 0, 1, 3};

      for(int i = 0; i < testOffsets.length; i++) {
        final int testOffset = testOffsets[i];
        final byte[] key = toArray(expected[testOffset].getKey().data());

        it.seek(key);
        assertThat(it.isValid()).isTrue();
        assertThat(it.entry().equals(expected[testOffset])).isTrue();
      }

      //forward iterative access
      int i = 0;
      for(it.seekToFirst(); it.isValid(); it.next()) {
        assertThat(it.entry().equals(expected[i++])).isTrue();
      }

      //reverse iterative access
      i = expected.length - 1;
      for(it.seekToLast(); it.isValid(); it.prev()) {
        assertThat(it.entry().equals(expected[i--])).isTrue();
      }

    } finally {
      if(it != null) {
        it.dispose();
=======
    try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true)) {

      final String k1 = "key1";
      final String v1 = "value1";
      final String k2 = "key2";
      final String v2 = "value2";
      final String k3 = "key3";
      final String v3 = "value3";
      final byte[] k1b = k1.getBytes();
      final byte[] v1b = v1.getBytes();
      final byte[] k2b = k2.getBytes();
      final byte[] v2b = v2.getBytes();
      final byte[] k3b = k3.getBytes();
      final byte[] v3b = v3.getBytes();

      //add put records
      wbwi.put(k1b, v1b);
      wbwi.put(k2b, v2b);
      wbwi.put(k3b, v3b);

      //add a deletion record
      final String k4 = "key4";
      final byte[] k4b = k4.getBytes();
      wbwi.remove(k4b);

      final WBWIRocksIterator.WriteEntry[] expected = {
          new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
              new DirectSlice(k1), new DirectSlice(v1)),
          new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
              new DirectSlice(k2), new DirectSlice(v2)),
          new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
              new DirectSlice(k3), new DirectSlice(v3)),
          new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.DELETE,
              new DirectSlice(k4), DirectSlice.NONE)
      };

      try (final WBWIRocksIterator it = wbwi.newIterator()) {
        //direct access - seek to key offsets
        final int[] testOffsets = {2, 0, 1, 3};

        for (int i = 0; i < testOffsets.length; i++) {
          final int testOffset = testOffsets[i];
          final byte[] key = toArray(expected[testOffset].getKey().data());

          it.seek(key);
          assertThat(it.isValid()).isTrue();

          final WBWIRocksIterator.WriteEntry entry = it.entry();
          assertThat(entry.equals(expected[testOffset])).isTrue();
        }

        //forward iterative access
        int i = 0;
        for (it.seekToFirst(); it.isValid(); it.next()) {
          assertThat(it.entry().equals(expected[i++])).isTrue();
        }

        //reverse iterative access
        i = expected.length - 1;
        for (it.seekToLast(); it.isValid(); it.prev()) {
          assertThat(it.entry().equals(expected[i--])).isTrue();
        }
      }
    }
  }

  @Test
  public void zeroByteTests() {
    try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true)) {
      final byte[] zeroByteValue = new byte[]{0, 0};
      //add zero byte value
      wbwi.put(zeroByteValue, zeroByteValue);

      final ByteBuffer buffer = ByteBuffer.allocateDirect(zeroByteValue.length);
      buffer.put(zeroByteValue);

      WBWIRocksIterator.WriteEntry[] expected = {
          new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
              new DirectSlice(buffer, zeroByteValue.length),
              new DirectSlice(buffer, zeroByteValue.length))
      };

      try (final WBWIRocksIterator it = wbwi.newIterator()) {
        it.seekToFirst();
        assertThat(it.entry().equals(expected[0])).isTrue();
        assertThat(it.entry().hashCode() == expected[0].hashCode()).isTrue();
>>>>>>> forknote/master
      }
    }
  }

  @Test
<<<<<<< HEAD
  public void zeroByteTests() {
    final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true);
    byte[] zeroByteValue = new byte[] { 0, 0 };

    //add zero byte value
    wbwi.put(zeroByteValue, zeroByteValue);

    ByteBuffer buffer = ByteBuffer.allocateDirect(zeroByteValue.length);
    buffer.put(zeroByteValue);

    WBWIRocksIterator.WriteEntry[] expected = {
        new WBWIRocksIterator.WriteEntry(WBWIRocksIterator.WriteType.PUT,
            new DirectSlice(buffer, zeroByteValue.length),
            new DirectSlice(buffer, zeroByteValue.length))
    };
    WBWIRocksIterator it = null;
    try {
      it = wbwi.newIterator();
      it.seekToFirst();
      assertThat(it.entry().equals(expected[0])).isTrue();
      assertThat(it.entry().hashCode() == expected[0].hashCode()).isTrue();
    } finally {
      if(it != null) {
        it.dispose();
=======
  public void savePoints()
      throws UnsupportedEncodingException, RocksDBException {
    try (final Options options = new Options().setCreateIfMissing(true);
         final RocksDB db = RocksDB.open(options,
             dbFolder.getRoot().getAbsolutePath())) {
      try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex(true);
           final ReadOptions readOptions = new ReadOptions()) {
        wbwi.put("k1".getBytes(), "v1".getBytes());
        wbwi.put("k2".getBytes(), "v2".getBytes());
        wbwi.put("k3".getBytes(), "v3".getBytes());

        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k1"))
            .isEqualTo("v1");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k2"))
            .isEqualTo("v2");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k3"))
            .isEqualTo("v3");


        wbwi.setSavePoint();

        wbwi.remove("k2".getBytes());
        wbwi.put("k3".getBytes(), "v3-2".getBytes());

        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k2"))
            .isNull();
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k3"))
            .isEqualTo("v3-2");


        wbwi.setSavePoint();

        wbwi.put("k3".getBytes(), "v3-3".getBytes());
        wbwi.put("k4".getBytes(), "v4".getBytes());

        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k3"))
            .isEqualTo("v3-3");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k4"))
            .isEqualTo("v4");


        wbwi.rollbackToSavePoint();

        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k2"))
            .isNull();
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k3"))
            .isEqualTo("v3-2");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k4"))
            .isNull();


        wbwi.rollbackToSavePoint();

        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k1"))
            .isEqualTo("v1");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k2"))
            .isEqualTo("v2");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k3"))
            .isEqualTo("v3");
        assertThat(getFromWriteBatchWithIndex(db, readOptions, wbwi, "k4"))
            .isNull();
>>>>>>> forknote/master
      }
    }
  }

<<<<<<< HEAD
=======
  @Test(expected = RocksDBException.class)
  public void restorePoints_withoutSavePoints() throws RocksDBException {
    try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex()) {
      wbwi.rollbackToSavePoint();
    }
  }

  @Test(expected = RocksDBException.class)
  public void restorePoints_withoutSavePoints_nested() throws RocksDBException {
    try (final WriteBatchWithIndex wbwi = new WriteBatchWithIndex()) {

      wbwi.setSavePoint();
      wbwi.rollbackToSavePoint();

      // without previous corresponding setSavePoint
      wbwi.rollbackToSavePoint();
    }
  }

  private static String getFromWriteBatchWithIndex(final RocksDB db,
      final ReadOptions readOptions, final WriteBatchWithIndex wbwi,
      final String skey) {
    final byte[] key = skey.getBytes();
    try(final RocksIterator baseIterator = db.newIterator(readOptions);
        final RocksIterator iterator = wbwi.newIteratorWithBase(baseIterator)) {
      iterator.seek(key);

      // Arrays.equals(key, iterator.key()) ensures an exact match in Rocks,
      // instead of a nearest match
      return iterator.isValid() &&
          Arrays.equals(key, iterator.key()) ?
          new String(iterator.value()) : null;
    }
  }

>>>>>>> forknote/master
  private byte[] toArray(final ByteBuffer buf) {
    final byte[] ary = new byte[buf.remaining()];
    buf.get(ary);
    return ary;
  }
}
