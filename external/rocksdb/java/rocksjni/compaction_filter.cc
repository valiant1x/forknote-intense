<<<<<<< HEAD
// Copyright (c) 2015, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.
//
// This file implements the "bridge" between Java and C++ for
// rocksdb::CompactionFilter.

#include <jni.h>

<<<<<<< HEAD
=======
#include "include/org_rocksdb_AbstractCompactionFilter.h"
>>>>>>> forknote/master
#include "rocksdb/compaction_filter.h"

// <editor-fold desc="org.rocksdb.AbstractCompactionFilter">

/*
 * Class:     org_rocksdb_AbstractCompactionFilter
 * Method:    disposeInternal
 * Signature: (J)V
 */
void Java_org_rocksdb_AbstractCompactionFilter_disposeInternal(
    JNIEnv* env, jobject jobj, jlong handle) {
  delete reinterpret_cast<rocksdb::CompactionFilter*>(handle);
}
// </editor-fold>
