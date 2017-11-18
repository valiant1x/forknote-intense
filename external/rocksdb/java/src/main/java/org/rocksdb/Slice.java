<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

/**
 * <p>Base class for slices which will receive
 * byte[] based access to the underlying data.</p>
 *
 * <p>byte[] backed slices typically perform better with
 * small keys and values. When using larger keys and
 * values consider using {@link org.rocksdb.DirectSlice}</p>
 */
public class Slice extends AbstractSlice<byte[]> {
  /**
   * <p>Called from JNI to construct a new Java Slice
   * without an underlying C++ object set
   * at creation time.</p>
   *
   * <p>Note: You should be aware that
   * {@see org.rocksdb.RocksObject#disOwnNativeHandle()} is intentionally
   * called from the default Slice constructor, and that it is marked as
   * private. This is so that developers cannot construct their own default
   * Slice objects (at present). As developers cannot construct their own
   * Slice objects through this, they are not creating underlying C++ Slice
   * objects, and so there is nothing to free (dispose) from Java.</p>
   */
  private Slice() {
    super();
<<<<<<< HEAD
    disOwnNativeHandle();
=======
>>>>>>> forknote/master
  }

  /**
   * <p>Constructs a slice where the data is taken from
   * a String.</p>
   *
   * @param str String value.
   */
  public Slice(final String str) {
<<<<<<< HEAD
    super();
    createNewSliceFromString(str);
=======
    super(createNewSliceFromString(str));
>>>>>>> forknote/master
  }

  /**
   * <p>Constructs a slice where the data is a copy of
   * the byte array from a specific offset.</p>
   *
   * @param data byte array.
   * @param offset offset within the byte array.
   */
  public Slice(final byte[] data, final int offset) {
<<<<<<< HEAD
    super();
    createNewSlice0(data, offset);
=======
    super(createNewSlice0(data, offset));
>>>>>>> forknote/master
  }

  /**
   * <p>Constructs a slice where the data is a copy of
   * the byte array.</p>
   *
   * @param data byte array.
   */
  public Slice(final byte[] data) {
<<<<<<< HEAD
    super();
    createNewSlice1(data);
=======
    super(createNewSlice1(data));
>>>>>>> forknote/master
  }

  /**
   * <p>Deletes underlying C++ slice pointer
   * and any buffered data.</p>
   *
   * <p>
   * Note that this function should be called only after all
   * RocksDB instances referencing the slice are closed.
   * Otherwise an undefined behavior will occur.</p>
   */
  @Override
  protected void disposeInternal() {
<<<<<<< HEAD
    disposeInternalBuf(nativeHandle_);
    super.disposeInternal();
  }

  @Override protected final native byte[] data0(long handle);
  private native void createNewSlice0(byte[] data, int length);
  private native void createNewSlice1(byte[] data);
  private native void disposeInternalBuf(long handle);
=======
    final long nativeHandle = getNativeHandle();
    disposeInternalBuf(nativeHandle);
    super.disposeInternal(nativeHandle);
  }

  @Override protected final native byte[] data0(long handle);
  private native static long createNewSlice0(final byte[] data,
      final int length);
  private native static long createNewSlice1(final byte[] data);
  private native void disposeInternalBuf(final long handle);
>>>>>>> forknote/master
}
