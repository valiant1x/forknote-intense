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
public abstract class AbstractWriteBatch extends RocksObject implements WriteBatchInterface {

  @Override
  public int count() {
    assert (isInitialized());
    return count0();
=======
public abstract class AbstractWriteBatch extends RocksObject
    implements WriteBatchInterface {

  protected AbstractWriteBatch(final long nativeHandle) {
    super(nativeHandle);
  }

  @Override
  public int count() {
    assert (isOwningHandle());
    return count0(nativeHandle_);
>>>>>>> forknote/master
  }

  @Override
  public void put(byte[] key, byte[] value) {
<<<<<<< HEAD
    assert (isInitialized());
    put(key, key.length, value, value.length);
  }

  @Override
  public void put(ColumnFamilyHandle columnFamilyHandle, byte[] key, byte[] value) {
    assert (isInitialized());
    put(key, key.length, value, value.length, columnFamilyHandle.nativeHandle_);
=======
    assert (isOwningHandle());
    put(nativeHandle_, key, key.length, value, value.length);
  }

  @Override
  public void put(ColumnFamilyHandle columnFamilyHandle, byte[] key,
      byte[] value) {
    assert (isOwningHandle());
    put(nativeHandle_, key, key.length, value, value.length,
        columnFamilyHandle.nativeHandle_);
>>>>>>> forknote/master
  }

  @Override
  public void merge(byte[] key, byte[] value) {
<<<<<<< HEAD
    assert (isInitialized());
    merge(key, key.length, value, value.length);
  }

  @Override
  public void merge(ColumnFamilyHandle columnFamilyHandle, byte[] key, byte[] value) {
    assert (isInitialized());
    merge(key, key.length, value, value.length, columnFamilyHandle.nativeHandle_);
=======
    assert (isOwningHandle());
    merge(nativeHandle_, key, key.length, value, value.length);
  }

  @Override
  public void merge(ColumnFamilyHandle columnFamilyHandle, byte[] key,
      byte[] value) {
    assert (isOwningHandle());
    merge(nativeHandle_, key, key.length, value, value.length,
        columnFamilyHandle.nativeHandle_);
>>>>>>> forknote/master
  }

  @Override
  public void remove(byte[] key) {
<<<<<<< HEAD
    assert (isInitialized());
    remove(key, key.length);
=======
    assert (isOwningHandle());
    remove(nativeHandle_, key, key.length);
>>>>>>> forknote/master
  }

  @Override
  public void remove(ColumnFamilyHandle columnFamilyHandle, byte[] key) {
<<<<<<< HEAD
    assert (isInitialized());
    remove(key, key.length, columnFamilyHandle.nativeHandle_);
=======
    assert (isOwningHandle());
    remove(nativeHandle_, key, key.length, columnFamilyHandle.nativeHandle_);
>>>>>>> forknote/master
  }

  @Override
  public void putLogData(byte[] blob) {
<<<<<<< HEAD
    assert (isInitialized());
    putLogData(blob, blob.length);
=======
    assert (isOwningHandle());
    putLogData(nativeHandle_, blob, blob.length);
>>>>>>> forknote/master
  }

  @Override
  public void clear() {
<<<<<<< HEAD
    assert (isInitialized());
    clear0();
  }

  /**
   * Delete the c++ side pointer.
   */
  @Override
  protected void disposeInternal() {
    assert (isInitialized());
    disposeInternal(nativeHandle_);
  }

  abstract void disposeInternal(long handle);

  abstract int count0();

  abstract void put(byte[] key, int keyLen, byte[] value, int valueLen);

  abstract void put(byte[] key, int keyLen, byte[] value, int valueLen, long cfHandle);

  abstract void merge(byte[] key, int keyLen, byte[] value, int valueLen);

  abstract void merge(byte[] key, int keyLen, byte[] value, int valueLen, long cfHandle);

  abstract void remove(byte[] key, int keyLen);

  abstract void remove(byte[] key, int keyLen, long cfHandle);

  abstract void putLogData(byte[] blob, int blobLen);

  abstract void clear0();
=======
    assert (isOwningHandle());
    clear0(nativeHandle_);
  }

  @Override
  public void setSavePoint() {
    assert (isOwningHandle());
    setSavePoint0(nativeHandle_);
  }

  @Override
  public void rollbackToSavePoint() throws RocksDBException {
    assert (isOwningHandle());
    rollbackToSavePoint0(nativeHandle_);
  }

  abstract int count0(final long handle);

  abstract void put(final long handle, final byte[] key, final int keyLen,
      final byte[] value, final int valueLen);

  abstract void put(final long handle, final byte[] key, final int keyLen,
      final byte[] value, final int valueLen, final long cfHandle);

  abstract void merge(final long handle, final byte[] key, final int keyLen,
      final byte[] value, final int valueLen);

  abstract void merge(final long handle, final byte[] key, final int keyLen,
      final byte[] value, final int valueLen, final long cfHandle);

  abstract void remove(final long handle, final byte[] key,
      final int keyLen);

  abstract void remove(final long handle, final byte[] key,
      final int keyLen, final long cfHandle);

  abstract void putLogData(final long handle, final byte[] blob,
      final int blobLen);

  abstract void clear0(final long handle);

  abstract void setSavePoint0(final long handle);

  abstract void rollbackToSavePoint0(final long handle);
>>>>>>> forknote/master
}
