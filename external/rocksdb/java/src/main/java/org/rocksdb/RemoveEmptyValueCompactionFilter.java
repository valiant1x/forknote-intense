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
 * Just a Java wrapper around EmptyValueCompactionFilter implemented in C++
 */
<<<<<<< HEAD
public class RemoveEmptyValueCompactionFilter extends AbstractCompactionFilter<Slice> {
  public RemoveEmptyValueCompactionFilter() {
    super();
    createNewRemoveEmptyValueCompactionFilter0();
  }

  private native void createNewRemoveEmptyValueCompactionFilter0();
=======
public class RemoveEmptyValueCompactionFilter
    extends AbstractCompactionFilter<Slice> {
  public RemoveEmptyValueCompactionFilter() {
    super(createNewRemoveEmptyValueCompactionFilter0());
  }

  private native static long createNewRemoveEmptyValueCompactionFilter0();
>>>>>>> forknote/master
}
