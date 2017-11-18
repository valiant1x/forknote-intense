<<<<<<< HEAD
//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.

#pragma once

#include <stdint.h>
<<<<<<< HEAD
#include <deque>
#include <set>
#include <vector>
=======
#include <atomic>
#include <mutex>
#include <set>
>>>>>>> forknote/master

namespace rocksdb {

class ColumnFamilyData;

<<<<<<< HEAD
// This class is thread-compatible. It's should only be accessed from single
// write thread (between BeginWrite() and EndWrite())
class FlushScheduler {
 public:
  FlushScheduler() = default;
  ~FlushScheduler() = default;

  void ScheduleFlush(ColumnFamilyData* cfd);
  // Returns Ref()-ed column family. Client needs to Unref()
  // REQUIRES: db mutex is held (exception is single-threaded recovery)
  ColumnFamilyData* GetNextColumnFamily();
=======
// Unless otherwise noted, all methods on FlushScheduler should be called
// only with the DB mutex held or from a single-threaded recovery context.
class FlushScheduler {
 public:
  FlushScheduler() : head_(nullptr) {}

  // May be called from multiple threads at once, but not concurrent with
  // any other method calls on this instance
  void ScheduleFlush(ColumnFamilyData* cfd);

  // Removes and returns Ref()-ed column family. Client needs to Unref().
  // Filters column families that have been dropped.
  ColumnFamilyData* TakeNextColumnFamily();
>>>>>>> forknote/master

  bool Empty();

  void Clear();

 private:
<<<<<<< HEAD
  std::deque<ColumnFamilyData*> column_families_;
#ifndef NDEBUG
  std::set<ColumnFamilyData*> column_families_set_;
=======
  struct Node {
    ColumnFamilyData* column_family;
    Node* next;
  };

  std::atomic<Node*> head_;
#ifndef NDEBUG
  std::mutex checking_mutex_;
  std::set<ColumnFamilyData*> checking_set_;
>>>>>>> forknote/master
#endif  // NDEBUG
};

}  // namespace rocksdb
