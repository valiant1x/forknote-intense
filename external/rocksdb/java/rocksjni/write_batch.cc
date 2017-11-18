<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.
//
// This file implements the "bridge" between Java and C++ and enables
// calling c++ rocksdb::WriteBatch methods from Java side.
#include <memory>

<<<<<<< HEAD
#include "include/org_rocksdb_WriteBatch.h"
#include "include/org_rocksdb_WriteBatch_Handler.h"
#include "rocksjni/portal.h"
#include "rocksjni/writebatchhandlerjnicallback.h"
#include "rocksdb/db.h"
#include "rocksdb/immutable_options.h"
#include "db/memtable.h"
#include "rocksdb/write_batch.h"
#include "rocksdb/status.h"
#include "db/write_batch_internal.h"
#include "db/writebuffer.h"
#include "rocksdb/env.h"
#include "rocksdb/memtablerep.h"
#include "util/logging.h"
#include "util/scoped_arena_iterator.h"
=======
#include "db/memtable.h"
#include "db/write_batch_internal.h"
#include "include/org_rocksdb_WriteBatch.h"
#include "include/org_rocksdb_WriteBatch_Handler.h"
#include "rocksdb/db.h"
#include "rocksdb/env.h"
#include "rocksdb/immutable_options.h"
#include "rocksdb/memtablerep.h"
#include "rocksdb/status.h"
#include "rocksdb/write_batch.h"
#include "rocksdb/write_buffer_manager.h"
#include "rocksjni/portal.h"
#include "rocksjni/writebatchhandlerjnicallback.h"
#include "table/scoped_arena_iterator.h"
#include "util/logging.h"
>>>>>>> forknote/master
#include "util/testharness.h"

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    newWriteBatch
<<<<<<< HEAD
 * Signature: (I)V
 */
void Java_org_rocksdb_WriteBatch_newWriteBatch(
    JNIEnv* env, jobject jobj, jint jreserved_bytes) {
  rocksdb::WriteBatch* wb = new rocksdb::WriteBatch(
      static_cast<size_t>(jreserved_bytes));

  rocksdb::WriteBatchJni::setHandle(env, jobj, wb);
=======
 * Signature: (I)J
 */
jlong Java_org_rocksdb_WriteBatch_newWriteBatch(
    JNIEnv* env, jclass jcls, jint jreserved_bytes) {
  rocksdb::WriteBatch* wb = new rocksdb::WriteBatch(
      static_cast<size_t>(jreserved_bytes));
  return reinterpret_cast<jlong>(wb);
>>>>>>> forknote/master
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    count0
<<<<<<< HEAD
 * Signature: ()I
 */
jint Java_org_rocksdb_WriteBatch_count0(JNIEnv* env, jobject jobj) {
  rocksdb::WriteBatch* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J)I
 */
jint Java_org_rocksdb_WriteBatch_count0(JNIEnv* env, jobject jobj,
    jlong jwb_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);

  return static_cast<jint>(wb->Count());
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    clear0
<<<<<<< HEAD
 * Signature: ()V
 */
void Java_org_rocksdb_WriteBatch_clear0(JNIEnv* env, jobject jobj) {
  rocksdb::WriteBatch* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J)V
 */
void Java_org_rocksdb_WriteBatch_clear0(JNIEnv* env, jobject jobj,
    jlong jwb_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);

  wb->Clear();
}

/*
 * Class:     org_rocksdb_WriteBatch
<<<<<<< HEAD
 * Method:    put
 * Signature: ([BI[BI)V
 */
void Java_org_rocksdb_WriteBatch_put___3BI_3BI(
    JNIEnv* env, jobject jobj,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Method:    setSavePoint0
 * Signature: (J)V
 */
void Java_org_rocksdb_WriteBatch_setSavePoint0(
    JNIEnv* env, jobject jobj, jlong jwb_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
  assert(wb != nullptr);

  wb->SetSavePoint();
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    rollbackToSavePoint0
 * Signature: (J)V
 */
void Java_org_rocksdb_WriteBatch_rollbackToSavePoint0(
    JNIEnv* env, jobject jobj, jlong jwb_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
  assert(wb != nullptr);

  auto s = wb->RollbackToSavePoint();

  if (s.ok()) {
    return;
  }
  rocksdb::RocksDBExceptionJni::ThrowNew(env, s);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    put
 * Signature: (J[BI[BI)V
 */
void Java_org_rocksdb_WriteBatch_put__J_3BI_3BI(
    JNIEnv* env, jobject jobj, jlong jwb_handle,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto put = [&wb] (rocksdb::Slice key, rocksdb::Slice value) {
    wb->Put(key, value);
  };
  rocksdb::JniUtil::kv_op(put, env, jobj, jkey, jkey_len, jentry_value,
      jentry_value_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    put
<<<<<<< HEAD
 * Signature: ([BI[BIJ)V
 */
void Java_org_rocksdb_WriteBatch_put___3BI_3BIJ(
    JNIEnv* env, jobject jobj,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len, jlong jcf_handle) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J[BI[BIJ)V
 */
void Java_org_rocksdb_WriteBatch_put__J_3BI_3BIJ(
    JNIEnv* env, jobject jobj, jlong jwb_handle,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len, jlong jcf_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto* cf_handle = reinterpret_cast<rocksdb::ColumnFamilyHandle*>(jcf_handle);
  assert(cf_handle != nullptr);
  auto put = [&wb, &cf_handle] (rocksdb::Slice key, rocksdb::Slice value) {
    wb->Put(cf_handle, key, value);
  };
  rocksdb::JniUtil::kv_op(put, env, jobj, jkey, jkey_len, jentry_value,
      jentry_value_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    merge
<<<<<<< HEAD
 * Signature: ([BI[BI)V
 */
void Java_org_rocksdb_WriteBatch_merge___3BI_3BI(
    JNIEnv* env, jobject jobj,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J[BI[BI)V
 */
void Java_org_rocksdb_WriteBatch_merge__J_3BI_3BI(
    JNIEnv* env, jobject jobj, jlong jwb_handle,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto merge = [&wb] (rocksdb::Slice key, rocksdb::Slice value) {
    wb->Merge(key, value);
  };
  rocksdb::JniUtil::kv_op(merge, env, jobj, jkey, jkey_len, jentry_value,
      jentry_value_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    merge
<<<<<<< HEAD
 * Signature: ([BI[BIJ)V
 */
void Java_org_rocksdb_WriteBatch_merge___3BI_3BIJ(
    JNIEnv* env, jobject jobj,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len, jlong jcf_handle) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J[BI[BIJ)V
 */
void Java_org_rocksdb_WriteBatch_merge__J_3BI_3BIJ(
    JNIEnv* env, jobject jobj, jlong jwb_handle,
    jbyteArray jkey, jint jkey_len,
    jbyteArray jentry_value, jint jentry_value_len, jlong jcf_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto* cf_handle = reinterpret_cast<rocksdb::ColumnFamilyHandle*>(jcf_handle);
  assert(cf_handle != nullptr);
  auto merge = [&wb, &cf_handle] (rocksdb::Slice key, rocksdb::Slice value) {
    wb->Merge(cf_handle, key, value);
  };
  rocksdb::JniUtil::kv_op(merge, env, jobj, jkey, jkey_len, jentry_value,
      jentry_value_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    remove
<<<<<<< HEAD
 * Signature: ([BI)V
 */
void Java_org_rocksdb_WriteBatch_remove___3BI(
    JNIEnv* env, jobject jobj,
    jbyteArray jkey, jint jkey_len) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J[BI)V
 */
void Java_org_rocksdb_WriteBatch_remove__J_3BI(
    JNIEnv* env, jobject jobj, jlong jwb_handle,
    jbyteArray jkey, jint jkey_len) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto remove = [&wb] (rocksdb::Slice key) {
    wb->Delete(key);
  };
  rocksdb::JniUtil::k_op(remove, env, jobj, jkey, jkey_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    remove
<<<<<<< HEAD
 * Signature: ([BIJ)V
 */
void Java_org_rocksdb_WriteBatch_remove___3BIJ(
    JNIEnv* env, jobject jobj,
    jbyteArray jkey, jint jkey_len, jlong jcf_handle) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J[BIJ)V
 */
void Java_org_rocksdb_WriteBatch_remove__J_3BIJ(
    JNIEnv* env, jobject jobj, jlong jwb_handle,
    jbyteArray jkey, jint jkey_len, jlong jcf_handle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto* cf_handle = reinterpret_cast<rocksdb::ColumnFamilyHandle*>(jcf_handle);
  assert(cf_handle != nullptr);
  auto remove = [&wb, &cf_handle] (rocksdb::Slice key) {
    wb->Delete(cf_handle, key);
  };
  rocksdb::JniUtil::k_op(remove, env, jobj, jkey, jkey_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    putLogData
<<<<<<< HEAD
 * Signature: ([BI)V
 */
void Java_org_rocksdb_WriteBatch_putLogData(
    JNIEnv* env, jobject jobj, jbyteArray jblob, jint jblob_len) {
  auto* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (J[BI)V
 */
void Java_org_rocksdb_WriteBatch_putLogData(
    JNIEnv* env, jobject jobj, jlong jwb_handle, jbyteArray jblob,
    jint jblob_len) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);
  auto putLogData = [&wb] (rocksdb::Slice blob) {
    wb->PutLogData(blob);
  };
  rocksdb::JniUtil::k_op(putLogData, env, jobj, jblob, jblob_len);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    iterate
<<<<<<< HEAD
 * Signature: (J)V
 */
void Java_org_rocksdb_WriteBatch_iterate(
    JNIEnv* env , jobject jobj, jlong handlerHandle) {
  rocksdb::WriteBatch* wb = rocksdb::WriteBatchJni::getHandle(env, jobj);
=======
 * Signature: (JJ)V
 */
void Java_org_rocksdb_WriteBatch_iterate(
    JNIEnv* env , jobject jobj, jlong jwb_handle, jlong handlerHandle) {
  auto* wb = reinterpret_cast<rocksdb::WriteBatch*>(jwb_handle);
>>>>>>> forknote/master
  assert(wb != nullptr);

  rocksdb::Status s = wb->Iterate(
    reinterpret_cast<rocksdb::WriteBatchHandlerJniCallback*>(handlerHandle));

  if (s.ok()) {
    return;
  }
  rocksdb::RocksDBExceptionJni::ThrowNew(env, s);
}

/*
 * Class:     org_rocksdb_WriteBatch
 * Method:    disposeInternal
 * Signature: (J)V
 */
void Java_org_rocksdb_WriteBatch_disposeInternal(
    JNIEnv* env, jobject jobj, jlong handle) {
  delete reinterpret_cast<rocksdb::WriteBatch*>(handle);
}

/*
 * Class:     org_rocksdb_WriteBatch_Handler
 * Method:    createNewHandler0
<<<<<<< HEAD
 * Signature: ()V
 */
void Java_org_rocksdb_WriteBatch_00024Handler_createNewHandler0(
    JNIEnv* env, jobject jobj) {
  const rocksdb::WriteBatchHandlerJniCallback* h =
    new rocksdb::WriteBatchHandlerJniCallback(env, jobj);
  rocksdb::WriteBatchHandlerJni::setHandle(env, jobj, h);
=======
 * Signature: ()J
 */
jlong Java_org_rocksdb_WriteBatch_00024Handler_createNewHandler0(
    JNIEnv* env, jobject jobj) {
  const rocksdb::WriteBatchHandlerJniCallback* h =
    new rocksdb::WriteBatchHandlerJniCallback(env, jobj);
  return reinterpret_cast<jlong>(h);
>>>>>>> forknote/master
}

/*
 * Class:     org_rocksdb_WriteBatch_Handler
 * Method:    disposeInternal
 * Signature: (J)V
 */
void Java_org_rocksdb_WriteBatch_00024Handler_disposeInternal(
    JNIEnv* env, jobject jobj, jlong handle) {
  delete reinterpret_cast<rocksdb::WriteBatchHandlerJniCallback*>(handle);
}
