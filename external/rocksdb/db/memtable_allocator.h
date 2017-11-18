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
//
// This is used by the MemTable to allocate write buffer memory. It connects
<<<<<<< HEAD
// to WriteBuffer so we can track and enforce overall write buffer limits.

#pragma once
=======
// to WriteBufferManager so we can track and enforce overall write buffer
// limits.

#pragma once

#include <atomic>
#include "rocksdb/write_buffer_manager.h"
>>>>>>> forknote/master
#include "util/allocator.h"

namespace rocksdb {

<<<<<<< HEAD
class Arena;
class Logger;
class WriteBuffer;

class MemTableAllocator : public Allocator {
 public:
  explicit MemTableAllocator(Arena* arena, WriteBuffer* write_buffer);
=======
class Logger;

class MemTableAllocator : public Allocator {
 public:
  explicit MemTableAllocator(Allocator* allocator,
                             WriteBufferManager* write_buffer_manager);
>>>>>>> forknote/master
  ~MemTableAllocator();

  // Allocator interface
  char* Allocate(size_t bytes) override;
  char* AllocateAligned(size_t bytes, size_t huge_page_size = 0,
                        Logger* logger = nullptr) override;
  size_t BlockSize() const override;

  // Call when we're finished allocating memory so we can free it from
  // the write buffer's limit.
  void DoneAllocating();

 private:
<<<<<<< HEAD
  Arena* arena_;
  WriteBuffer* write_buffer_;
  size_t bytes_allocated_;
=======
  Allocator* allocator_;
  WriteBufferManager* write_buffer_manager_;
  std::atomic<size_t> bytes_allocated_;
>>>>>>> forknote/master

  // No copying allowed
  MemTableAllocator(const MemTableAllocator&);
  void operator=(const MemTableAllocator&);
};

}  // namespace rocksdb
