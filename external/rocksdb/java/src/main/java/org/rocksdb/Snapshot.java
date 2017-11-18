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
 * Snapshot of database
 */
public class Snapshot extends RocksObject {
  Snapshot(final long nativeHandle) {
<<<<<<< HEAD
    super();
    nativeHandle_ = nativeHandle;
=======
    super(nativeHandle);
>>>>>>> forknote/master
  }

  /**
   * Return the associated sequence number;
   *
   * @return the associated sequence number of
   *     this snapshot.
   */
  public long getSequenceNumber() {
<<<<<<< HEAD
    assert(isInitialized());
=======
    assert(isOwningHandle());
>>>>>>> forknote/master
    return getSequenceNumber(nativeHandle_);
  }

  /**
   * Dont release C++ Snapshot pointer. The pointer
   * to the snapshot is released by the database
   * instance.
   */
<<<<<<< HEAD
  @Override protected void disposeInternal() {
=======
  @Override
  protected final void disposeInternal(final long handle) {
>>>>>>> forknote/master
  }

  private native long getSequenceNumber(long handle);
}
