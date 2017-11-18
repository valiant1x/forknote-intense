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

#include "rocksdb/iterator.h"
<<<<<<< HEAD
=======
#include "table/internal_iterator.h"
>>>>>>> forknote/master
#include "table/iterator_wrapper.h"
#include "util/arena.h"

namespace rocksdb {

<<<<<<< HEAD
Iterator::Iterator() {
=======
Cleanable::Cleanable() {
>>>>>>> forknote/master
  cleanup_.function = nullptr;
  cleanup_.next = nullptr;
}

<<<<<<< HEAD
Iterator::~Iterator() {
=======
Cleanable::~Cleanable() {
>>>>>>> forknote/master
  if (cleanup_.function != nullptr) {
    (*cleanup_.function)(cleanup_.arg1, cleanup_.arg2);
    for (Cleanup* c = cleanup_.next; c != nullptr; ) {
      (*c->function)(c->arg1, c->arg2);
      Cleanup* next = c->next;
      delete c;
      c = next;
    }
  }
}

<<<<<<< HEAD
void Iterator::RegisterCleanup(CleanupFunction func, void* arg1, void* arg2) {
=======
void Cleanable::RegisterCleanup(CleanupFunction func, void* arg1, void* arg2) {
>>>>>>> forknote/master
  assert(func != nullptr);
  Cleanup* c;
  if (cleanup_.function == nullptr) {
    c = &cleanup_;
  } else {
    c = new Cleanup;
    c->next = cleanup_.next;
    cleanup_.next = c;
  }
  c->function = func;
  c->arg1 = arg1;
  c->arg2 = arg2;
}

<<<<<<< HEAD
=======
Status Iterator::GetProperty(std::string prop_name, std::string* prop) {
  if (prop == nullptr) {
    return Status::InvalidArgument("prop is nullptr");
  }
  if (prop_name == "rocksdb.iterator.is-key-pinned") {
    *prop = "0";
    return Status::OK();
  }
  return Status::InvalidArgument("Undentified property.");
}

>>>>>>> forknote/master
namespace {
class EmptyIterator : public Iterator {
 public:
  explicit EmptyIterator(const Status& s) : status_(s) { }
  virtual bool Valid() const override { return false; }
  virtual void Seek(const Slice& target) override {}
  virtual void SeekToFirst() override {}
  virtual void SeekToLast() override {}
  virtual void Next() override { assert(false); }
  virtual void Prev() override { assert(false); }
  Slice key() const override {
    assert(false);
    return Slice();
  }
  Slice value() const override {
    assert(false);
    return Slice();
  }
  virtual Status status() const override { return status_; }

 private:
  Status status_;
};
<<<<<<< HEAD
=======

class EmptyInternalIterator : public InternalIterator {
 public:
  explicit EmptyInternalIterator(const Status& s) : status_(s) {}
  virtual bool Valid() const override { return false; }
  virtual void Seek(const Slice& target) override {}
  virtual void SeekToFirst() override {}
  virtual void SeekToLast() override {}
  virtual void Next() override { assert(false); }
  virtual void Prev() override { assert(false); }
  Slice key() const override {
    assert(false);
    return Slice();
  }
  Slice value() const override {
    assert(false);
    return Slice();
  }
  virtual Status status() const override { return status_; }

 private:
  Status status_;
};
>>>>>>> forknote/master
}  // namespace

Iterator* NewEmptyIterator() {
  return new EmptyIterator(Status::OK());
}

<<<<<<< HEAD
Iterator* NewEmptyIterator(Arena* arena) {
  if (arena == nullptr) {
    return NewEmptyIterator();
  } else {
    auto mem = arena->AllocateAligned(sizeof(EmptyIterator));
    return new (mem) EmptyIterator(Status::OK());
  }
}

Iterator* NewErrorIterator(const Status& status) {
  return new EmptyIterator(status);
}

Iterator* NewErrorIterator(const Status& status, Arena* arena) {
  if (arena == nullptr) {
    return NewErrorIterator(status);
  } else {
    auto mem = arena->AllocateAligned(sizeof(EmptyIterator));
    return new (mem) EmptyIterator(status);
=======
Iterator* NewErrorIterator(const Status& status) {
  return new EmptyIterator(status);
}

InternalIterator* NewEmptyInternalIterator() {
  return new EmptyInternalIterator(Status::OK());
}

InternalIterator* NewEmptyInternalIterator(Arena* arena) {
  if (arena == nullptr) {
    return NewEmptyInternalIterator();
  } else {
    auto mem = arena->AllocateAligned(sizeof(EmptyIterator));
    return new (mem) EmptyInternalIterator(Status::OK());
  }
}

InternalIterator* NewErrorInternalIterator(const Status& status) {
  return new EmptyInternalIterator(status);
}

InternalIterator* NewErrorInternalIterator(const Status& status, Arena* arena) {
  if (arena == nullptr) {
    return NewErrorInternalIterator(status);
  } else {
    auto mem = arena->AllocateAligned(sizeof(EmptyIterator));
    return new (mem) EmptyInternalIterator(status);
>>>>>>> forknote/master
  }
}

}  // namespace rocksdb
