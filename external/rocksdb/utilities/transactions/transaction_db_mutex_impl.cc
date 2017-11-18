<<<<<<< HEAD
//  Copyright (c) 2015, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.

#ifndef ROCKSDB_LITE

#include "utilities/transactions/transaction_db_mutex_impl.h"

#include <chrono>
#include <condition_variable>
#include <functional>
#include <mutex>

#include "rocksdb/utilities/transaction_db_mutex.h"

namespace rocksdb {

class TransactionDBMutexImpl : public TransactionDBMutex {
 public:
  TransactionDBMutexImpl() {}
  ~TransactionDBMutexImpl() {}

  Status Lock() override;

  Status TryLockFor(int64_t timeout_time) override;

  void UnLock() override { mutex_.unlock(); }

  friend class TransactionDBCondVarImpl;

 private:
<<<<<<< HEAD
  std::timed_mutex mutex_;
=======
  std::mutex mutex_;
>>>>>>> forknote/master
};

class TransactionDBCondVarImpl : public TransactionDBCondVar {
 public:
  TransactionDBCondVarImpl() {}
  ~TransactionDBCondVarImpl() {}

  Status Wait(std::shared_ptr<TransactionDBMutex> mutex) override;

  Status WaitFor(std::shared_ptr<TransactionDBMutex> mutex,
                 int64_t timeout_time) override;

  void Notify() override { cv_.notify_one(); }

  void NotifyAll() override { cv_.notify_all(); }

 private:
<<<<<<< HEAD
  std::condition_variable_any cv_;
=======
  std::condition_variable cv_;
>>>>>>> forknote/master
};

std::shared_ptr<TransactionDBMutex>
TransactionDBMutexFactoryImpl::AllocateMutex() {
  return std::shared_ptr<TransactionDBMutex>(new TransactionDBMutexImpl());
}

std::shared_ptr<TransactionDBCondVar>
TransactionDBMutexFactoryImpl::AllocateCondVar() {
  return std::shared_ptr<TransactionDBCondVar>(new TransactionDBCondVarImpl());
}

Status TransactionDBMutexImpl::Lock() {
  mutex_.lock();
  return Status::OK();
}

Status TransactionDBMutexImpl::TryLockFor(int64_t timeout_time) {
  bool locked = true;

<<<<<<< HEAD
  if (timeout_time < 0) {
    // If timeout is negative, we wait indefinitely to acquire the lock
    mutex_.lock();
  } else if (timeout_time == 0) {
    locked = mutex_.try_lock();
  } else {
    // Attempt to acquire the lock unless we timeout
    auto duration = std::chrono::microseconds(timeout_time);
    locked = mutex_.try_lock_for(duration);
=======
  if (timeout_time == 0) {
    locked = mutex_.try_lock();
  } else {
    // Previously, this code used a std::timed_mutex.  However, this was changed
    // due to known bugs in gcc versions < 4.9.
    // https://gcc.gnu.org/bugzilla/show_bug.cgi?id=54562
    //
    // Since this mutex isn't held for long and only a single mutex is ever
    // held at a time, it is reasonable to ignore the lock timeout_time here
    // and only check it when waiting on the condition_variable.
    mutex_.lock();
>>>>>>> forknote/master
  }

  if (!locked) {
    // timeout acquiring mutex
    return Status::TimedOut(Status::SubCode::kMutexTimeout);
  }

  return Status::OK();
}

Status TransactionDBCondVarImpl::Wait(
    std::shared_ptr<TransactionDBMutex> mutex) {
  auto mutex_impl = reinterpret_cast<TransactionDBMutexImpl*>(mutex.get());
<<<<<<< HEAD
  cv_.wait(mutex_impl->mutex_);
=======

  std::unique_lock<std::mutex> lock(mutex_impl->mutex_, std::adopt_lock);
  cv_.wait(lock);

  // Make sure unique_lock doesn't unlock mutex when it destructs
  lock.release();

>>>>>>> forknote/master
  return Status::OK();
}

Status TransactionDBCondVarImpl::WaitFor(
    std::shared_ptr<TransactionDBMutex> mutex, int64_t timeout_time) {
<<<<<<< HEAD
  auto mutex_impl = reinterpret_cast<TransactionDBMutexImpl*>(mutex.get());

  if (timeout_time < 0) {
    // If timeout is negative, do not use a timeout
    cv_.wait(mutex_impl->mutex_);
  } else {
    auto duration = std::chrono::microseconds(timeout_time);
    auto cv_status = cv_.wait_for(mutex_impl->mutex_, duration);

    // Check if the wait stopped due to timing out.
    if (cv_status == std::cv_status::timeout) {
      return Status::TimedOut(Status::SubCode::kMutexTimeout);
    }
  }

  // CV was signaled, or we spuriously woke up (but didn't time out)
  return Status::OK();
=======
  Status s;

  auto mutex_impl = reinterpret_cast<TransactionDBMutexImpl*>(mutex.get());
  std::unique_lock<std::mutex> lock(mutex_impl->mutex_, std::adopt_lock);

  if (timeout_time < 0) {
    // If timeout is negative, do not use a timeout
    cv_.wait(lock);
  } else {
    auto duration = std::chrono::microseconds(timeout_time);
    auto cv_status = cv_.wait_for(lock, duration);

    // Check if the wait stopped due to timing out.
    if (cv_status == std::cv_status::timeout) {
      s = Status::TimedOut(Status::SubCode::kMutexTimeout);
    }
  }

  // Make sure unique_lock doesn't unlock mutex when it destructs
  lock.release();

  // CV was signaled, or we spuriously woke up (but didn't time out)
  return s;
>>>>>>> forknote/master
}

}  // namespace rocksdb

#endif  // ROCKSDB_LITE
