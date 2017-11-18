<<<<<<< HEAD
//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.
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
//
#pragma once
#include "rocksdb/env.h"

namespace rocksdb {

class TableCache;
class VersionStorageInfo;
class VersionEdit;
struct FileMetaData;
class InternalStats;

// A helper class so we can efficiently apply a whole sequence
// of edits to a particular state without creating intermediate
// Versions that contain full copies of the intermediate state.
class VersionBuilder {
 public:
  VersionBuilder(const EnvOptions& env_options, TableCache* table_cache,
<<<<<<< HEAD
                 VersionStorageInfo* base_vstorage);
=======
                 VersionStorageInfo* base_vstorage, Logger* info_log = nullptr);
>>>>>>> forknote/master
  ~VersionBuilder();
  void CheckConsistency(VersionStorageInfo* vstorage);
  void CheckConsistencyForDeletes(VersionEdit* edit, uint64_t number,
                                  int level);
  void Apply(VersionEdit* edit);
  void SaveTo(VersionStorageInfo* vstorage);
<<<<<<< HEAD
  void LoadTableHandlers(InternalStats* internal_stats, int max_threads = 1);
=======
  void LoadTableHandlers(InternalStats* internal_stats, int max_threads,
                         bool prefetch_index_and_filter_in_cache);
>>>>>>> forknote/master
  void MaybeAddFile(VersionStorageInfo* vstorage, int level, FileMetaData* f);

 private:
  class Rep;
  Rep* rep_;
};

extern bool NewestFirstBySeqNo(FileMetaData* a, FileMetaData* b);
}  // namespace rocksdb
